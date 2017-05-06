#include <ESP8266WiFi.h>
#include <ArduinoJson.h>
#include <EEPROM.h>

char emode[1] = "";
char code[128] = "";
char estatus[32] = "";

char ssid[32] = "";
char keyorpass[32] = "";
char keyIndex[32] = "";

const char* defaultssid         = "MyNetwork";  
const char* default_password     = "itsourwifi";

const char* host         = "52.40.64.243";  
String path              = "/springjpaexample/ikk/apple1";

const int pin            = 2; //blue light

int loadCredentials() {
  EEPROM.begin(512);

  //Retreve mode
  int size = 0;
  EEPROM.get(size, emode);
  
  //retreve code
  size = size + sizeof(emode); 
  EEPROM.get(size, code);

  //Retreve status
  size = size + sizeof(code); 
  EEPROM.get(size, estatus);

  //Retreve ssid
  size = size + sizeof(estatus); 
  EEPROM.get(size, ssid);

  //Retreve key or password
  size = size + sizeof(ssid); 
  EEPROM.get(size, keyorpass);

  //Retreve keyIndex
  size = size + sizeof(keyorpass); 
  EEPROM.get(size, keyIndex);

  EEPROM.end();
  
  Serial.println("Recovered credentials:");
  Serial.println(emode);
  Serial.println(code);
  Serial.println(estatus);
  Serial.println(ssid);
  Serial.println(keyorpass);
  Serial.println(keyIndex);

  return 1;
}

void setup() {
  pinMode(pin, OUTPUT); 
  pinMode(pin, HIGH);
  Serial.begin(115200);
  delay(10);
  loadCredentials();
  Serial.print("Connecting to ");
  Serial.println(ssid);
  int tries = 4;


  if (String(emode) != String("1")) {
    WiFi.begin(ssid);
  }

  if (String(emode) != String("2")) {
    WiFi.begin(ssid, keyorpass);
  }

  while (WiFi.status() != WL_CONNECTED) {
    
    if(tries == 0){
      lights(5, 200, 1);//error
    }
    delay(500);
    if(WiFi.status() == WL_NO_SSID_AVAIL){
        Serial.println("Using secondary credentials to connect");
        WiFi.begin(defaultssid, default_password);
        tries = 4;
    }
    tries--;
  }

  Serial.print("WiFi connected!");
}

void lights(int count, int edelay, int message){
  int flag=1;
  while(count!=0){
    if(flag==1){
      //high on light
      digitalWrite(pin, HIGH);
      flag=0;
    }else{
      //low on light
      digitalWrite(pin, LOW);
      flag=1;
    }
    delay(edelay);
    count--;
  }

  if(message==0){
    Serial.println("Success light");
  }else{
    Serial.println("Error light");
  }
  //deep sleep
}

/** Store WLAN credentials to EEPROM */
void saveCredentials() {
  EEPROM.begin(512);

  int size =0;
  EEPROM.put(size, emode);

  size =size+ sizeof(emode); 
  EEPROM.put(size, code);

  size =size+ sizeof(code); 
  EEPROM.put(size, estatus);

  size =size+ sizeof(estatus); 
  EEPROM.put(size, ssid);

  size =size+ sizeof(ssid); 
  EEPROM.put(size, keyorpass);

  size =size+ sizeof(keyorpass); 
  EEPROM.put(size, keyIndex);

  EEPROM.commit();
  EEPROM.end();
  Serial.println("New Credentials saved");
}

void loop() {  
  Serial.print("connecting to ");
  Serial.println(host);

  WiFiClient client;
  const int httpPort = 8080;
  int loop =1;
  
  while(loop == 1){
    if (!client.connect(host, httpPort)) {
      Serial.println("connection failed");
      delay(500);
      loop =1;
    }else{
      Serial.println("connection success");
      loop = 0;
    }
  }

  client.print(String("GET ") + path + " HTTP/1.1\r\n" +
               "Host: " + host + "\r\n" + 
               "Connection: keep-alive\r\n\r\n");

  delay(500); // wait for server to respond

  // read response
  String section="header";
  loop =1;
  while(loop == 1){
    if(client.available()){
      String line = client.readStringUntil('\r');
      if (section=="header") {
        Serial.print(".");
        if (line=="\n") { 
          section="json";
        }
      }
      else if (section=="json") {
        section="ignore";
        String result = line.substring(1);
        Serial.print("Result: ");
        Serial.println(result);
        int size = result.length() + 1;
        char json[size];
        result.toCharArray(json, size);
        StaticJsonBuffer<200> jsonBuffer;
        JsonObject& json_parsed = jsonBuffer.parseObject(json);
        if (!json_parsed.success())
        {
          Serial.println("parseObject() failed");
          return;
        }
        String sestatus = json_parsed["status"];
        sestatus.toCharArray(estatus, sestatus.length() + 1);
        if(strcmp(estatus, "decline") == 0 || strcmp(estatus, "error") == 0){
          saveCredentials();
          lights(5, 200, 1);//error
        }
        String semode = json_parsed["mode"];
        String scode = json_parsed["code"];
        sestatus.toCharArray(estatus, sestatus.length() + 1);
        sestatus.toCharArray(estatus, sestatus.length() + 1);
        
        if(strcmp(emode, "4") != 0 ){
          String s_ssid = json_parsed["ssid"];
          s_ssid.toCharArray(ssid, s_ssid.length() + 1);
        }

        if(strcmp(emode, "2") == 0 ){
          String skeyorpass = json_parsed["keyorpass"];
          skeyorpass.toCharArray(keyorpass, skeyorpass.length() + 1);
        }

        if(strcmp(emode, "3") == 0 ){
          String skeyorpass = json_parsed["keyorpass"];
          String skeyIndex = json_parsed["keyIndex"];
          skeyorpass.toCharArray(keyorpass, skeyorpass.length() + 1);
          skeyIndex.toCharArray(keyIndex, skeyIndex.length() + 1);
        }
        saveCredentials();
        lights(10, 100, 0);
      }
    }else{
      delay(500);
    }
  } 
  Serial.println("closing connection. ");
}

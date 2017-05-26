#include <ESP8266WiFi.h>
#include <ArduinoJson.h>
#include <EEPROM.h>


char code[128];
char ssid[32];
char password[32];

const char* defaultssid         = "MyNetwork";
const char* default_password    = "itsourwifi";
const char* host                = "52.40.154.185";
String path                     = "/ikk/button/click/2";
const int pin                   = 2; //blue light
int maxAttemptsToConnect        = 2;

int loadCredentials() {
  EEPROM.begin(512);
  //Retreve ssid
  int size = 0;
  EEPROM.get(size, ssid);

  //Retreve key or password
  size = size + sizeof(ssid);
  EEPROM.get(size, code);

  size = size + sizeof(code);
  EEPROM.get(size, password);
  EEPROM.end();
  Serial.println("Recovered credentials:");
  Serial.println(ssid);
  Serial.println(password);
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

  const char* mango = "test";

  if (String(password).length() == 0) {
    strcpy(ssid, mango);
  }

  if (String(password).length() == 0) {
    Serial.print("If section: ");
    WiFi.begin(ssid);
  }
  else {
    Serial.print("else section: ");
    WiFi.begin(ssid, password);
  }

  while ( !(WiFi.status() == WL_CONNECTED || WiFi.status() == WL_NO_SSID_AVAIL) ) {
    Serial.print("Attempting to connect to Secondary network, SSID: ");
    Serial.println(ssid);
    Serial.print("WiFi status: ");
    Serial.println(WiFi.status());
    delay(1000);
  }

  Serial.print("WiFi status: ");
  Serial.println(WiFi.status());

  if (WiFi.status() != WL_CONNECTED) {
    Serial.println("Using Primary credentials");
    WiFi.begin(defaultssid, default_password);
  }

  while ( !(WiFi.status() == WL_CONNECTED || WiFi.status() == WL_NO_SSID_AVAIL || WiFi.status() == WL_DISCONNECTED ) ) {
    Serial.print("Attempting to connect to WEP network, SSID: ");
    Serial.println(defaultssid);
    delay(500);
  }

  Serial.print("WiFi status: ");
  Serial.println(WiFi.status());

  if (WiFi.status() != WL_CONNECTED) {
    lights(5, 200, 1);//error
  }

  Serial.print("WiFi connected!");
}

void lights(int count, int edelay, int message) {
  int flag = 1;
  while (count != 0) {
    if (flag == 1) {
      //high on light
      digitalWrite(pin, HIGH);
      flag = 0;
    } else {
      //low on light
      digitalWrite(pin, LOW);
      flag = 1;
    }
    delay(edelay);
    count--;
  }

  if (message == 0) {
    Serial.println("Success light");
  } else {
    Serial.println("Error light");
  }
  //deep sleep
}

/** Store WLAN credentials to EEPROM */
void saveCredentials() {
  EEPROM.begin(512);

  int size = 0;
  EEPROM.put(size, ssid);

  size = size + sizeof(ssid);
  EEPROM.put(size, code);

  size = size + sizeof(code);
  EEPROM.put(size, password);

  EEPROM.commit();
  EEPROM.end();
  Serial.println("New Credentials saved");
}

void loop() {
  Serial.print("connecting to ");
  Serial.println(host);

  WiFiClient client;

  while (!client.connect(host, 8080)) {
    Serial.println("connection failed");
    delay(500);
  }

  String PostData = "{\"code\":";
    PostData =  PostData + "\""+ code +"\"}";
    Serial.println(PostData);
    
  /*StaticJsonBuffer<200> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["code"] = code;
  char jsonChar[200];*/

  client.println("POST /ikk/button/click/2 HTTP/1.1");
  client.println("Host: jsonplaceholder.typicode.com");
  client.println("Cache-Control: no-cache");
  client.println("Content-Type: application/JSON");
  client.print("Content-Length: ");
  //client.println(root.measureLength() + 1);
  client.println(PostData.length());
  client.println();
  //client.println(root.printTo((char*)jsonChar, root.measureLength() + 1));
  client.println(PostData);

  while (!client.available()) {
    delay(1000);
  }

  while (client.connected())
  {
    if ( client.available() )
    {
      String line = client.readStringUntil('\r');
      Serial.println(line);
      /*if (line == "\n") {
          line = client.readStringUntil('\r');
          Serial.println("Done");
          Serial.print(line);
        }*/
    }
  }
}

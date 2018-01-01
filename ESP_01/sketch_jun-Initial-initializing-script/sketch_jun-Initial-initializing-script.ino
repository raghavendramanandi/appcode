#include <ESP8266WiFi.h>
#include <ArduinoJson.h>
#include <EEPROM.h>


char code[128];
char encycode[128];
char ssid[32];
char password[32];

const char* defaultssid         = "MyNetwork";
const char* default_password    = "itsourwifi";
const char* host                = "ec2-54-69-10-255.us-west-2.compute.amazonaws.com";
String path                     = "/button/click/3";
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
  
}

/** Store WLAN credentials to EEPROM */
void saveCredentials() {
  EEPROM.begin(512);

  int size = 0;
  EEPROM.put(size, ssid);

  size = size + sizeof(ssid);
  EEPROM.put(size, encycode);

  size = size + sizeof(encycode);
  EEPROM.put(size, password);

  EEPROM.commit();
  EEPROM.end();
  Serial.println("New Credentials saved");
}

void loop() {
  String name = "MyNetwork";
  name.toCharArray(ssid, name.length() + 1);
  name = "";
  name.toCharArray(encycode, name.length() + 1);
  name.toCharArray(code, name.length() + 1);
  name = "itsourwifi";
  name.toCharArray(password, name.length() + 1);

  saveCredentials();
  loadCredentials();

  delay(1000000);
}

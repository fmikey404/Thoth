#include <FirebaseESP32.h>
#include <WiFi.h>
FirebaseData fbDB;
const char* ssid = "UMB_student";
const char* pass = "5tud3ntUMb$1220l";


#define vrXDer 32
#define vrYDer 33
#define btnJstkDer 13
#define vrXIzq 35
#define vrYIzq 34
#define btnJstkIzq 21
#define btnAzul 5
#define btnVerde 22
#define btnRojo 23
int freq = 10000, res = 8;

void setup() {
  pinMode(vrXDer, INPUT);
  pinMode(vrYDer, INPUT);
  pinMode(btnJstkDer, INPUT_PULLUP);
  pinMode(vrXIzq, INPUT);
  pinMode(vrYIzq, INPUT);
  pinMode(btnJstkIzq, INPUT_PULLUP);
  pinMode(btnAzul, INPUT);
  pinMode(btnVerde, INPUT);
  pinMode(btnRojo, INPUT);
  
  Serial.begin(115200);
  Serial.print("Conectando a ");
  Serial.println(ssid);
  WiFi.begin(ssid, pass);
  while(WiFi.status() != WL_CONNECTED){
    delay(200);
    Serial.print(".");
  }
  Serial.print("\nRed ");
  Serial.print(ssid);
  Serial.println(" conectada");
  Firebase.begin("https://semilleroumb-ae38e-default-rtdb.firebaseio.com/", "Xj653N4b9y4CXtPmoHTrME5DJT6eILhXn76U9p33");
}

void loop() {
  Firebase.setInt(fbDB, "/1070004131/Juego/Colores/Azul", digitalRead(btnAzul));
  Firebase.setInt(fbDB, "/1070004131/Juego/Colores/Verde", digitalRead(btnVerde));
  Firebase.setInt(fbDB, "/1070004131/Juego/Colores/Rojo", digitalRead(btnRojo));
  Firebase.setInt(fbDB, "/1070004131/Juego/JoystickDer/X", map(analogRead(vrXDer), 0, 4095, 0, 2));
  Firebase.setInt(fbDB, "/1070004131/Juego/JoystickDer/Y", map(analogRead(vrYDer), 0, 4095, 0, 2));
  Firebase.setInt(fbDB, "/1070004131/Juego/JoystickDer/Btn", digitalRead(btnJstkDer));
  Firebase.setInt(fbDB, "/1070004131/Juego/JoystickIzq/X", map(analogRead(vrXIzq), 0, 4095, 0, 2));
  Firebase.setInt(fbDB, "/1070004131/Juego/JoystickIzq/Y", map(analogRead(vrYIzq), 0, 4095, 0, 2));
  Firebase.setInt(fbDB, "/1070004131/Juego/JoystickIzq/Btn", digitalRead(btnJstkIzq));
}

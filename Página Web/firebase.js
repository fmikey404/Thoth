import { initializeApp } from "https://www.gstatic.com/firebasejs/9.8.1/firebase-app.js";
  import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.8.1/firebase-analytics.js";
  // TODO: Add SDKs for Firebase products that you want to use
  // https://firebase.google.com/docs/web/setup#available-libraries

  // Your web app's Firebase configuration
  // For Firebase JS SDK v7.20.0 and later, measurementId is optional
  const firebaseConfig = {
    apiKey: "AIzaSyCWetrEKx0cSBR9PkD6Njyt1xF5jwTcW1E",
    authDomain: "semilleroumb-ae38e.firebaseapp.com",
    databaseURL: "https://semilleroumb-ae38e-default-rtdb.firebaseio.com",
    projectId: "semilleroumb-ae38e",
    storageBucket: "semilleroumb-ae38e.appspot.com",
    messagingSenderId: "314190376123",
    appId: "1:314190376123:web:65461b175571b4b5138d9e",
    measurementId: "G-BJHHFP7JER"
  };

  // Initialize Firebase
  const app = initializeApp(firebaseConfig);
  const analytics = getAnalytics(app);

import {getDatabase, ref, set} //Se genero una importacion a getDatabase, ref, set que nos servira para guardar los datos
from "https://www.gstatic.com/firebasejs/9.8.1/firebase-database.js"; //A su vez se importo el link del desrtino de los datos
const db = getDatabase(); //Se creo una constante db igualadolo al metodo getDatabase

// Se crean variables donde lo ingresado en los input sea leeido a igual que el boton
var nom = document.getElementById("Nom");
var cedula = document.getElementById("cc");
var edad = document.getElementById("Edad");
var condicion = document.getElementById("Condi");
var contraseña = document.getElementById("pass");




var Btn = document.getElementById("btn");

// Se hace una funcion donde lo leido sea guardado en metodo donde se imprimira en la database de firebase y donde
// la cedula sea el encabezado y id de todos los datos registrados
function salvarDatos(){
    set(ref(db, cedula.value+"/Datos/"),{
        Nombre: nom.value,
        User: Number(cedula.value),
        Edad: Number(edad.value),
        Condicion: condicion.value,
        Password: contraseña.value
        
    })
    .then( ()=>{
        alert("Se guardaron los datos con exito"); // Se realiza un catch para avisar si los datos fueron recibidos por
    })                                             // Firebase o si no lo fuero
    .catch((error)=>{
        alert("Se generado un error"+error);
    });
}
// Se define el boton con la propiedad addEventListener para llamr la funcion salvarDatos y asi guardar los datos
Btn.addEventListener("click", salvarDatos);

// ES IMPORTANTE RECORDAR QUE TODA LA CONEXION Y SUS FUNCUIONES DEBEN ESTAR EN LA ETIQUETA DE <scipt>
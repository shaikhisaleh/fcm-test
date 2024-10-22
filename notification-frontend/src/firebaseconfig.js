
import { initializeApp } from "firebase/app";
import { getMessaging,  } from "firebase/messaging";

  
// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const env = import.meta.env;
console.log(env.VITE_APP_API_KEY);

const firebaseConfig = {
apiKey: env.VITE_APP_API_KEY,
authDomain: env.VITE_APP_AUTH_DOMAIN,
projectId: env.VITE_APP_PROJECT_ID,
storageBucket: env.VITE_APP_STORAGE_BUCKET,
messagingSenderId: env.VITE_APP_MESSAGING_SENDER_ID,
appId: env.VITE_APP_ID,
measurementId: env.VITE_APP_MEASUREMENT_ID,
};

// Initialize Firebase
const firebase = initializeApp(firebaseConfig);
export const messaging = getMessaging();
 
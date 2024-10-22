import './App.css'
import { useEffect } from 'react';
import { getToken, onMessage} from "firebase/messaging";
import { toast, ToastContainer } from "react-toastify";
import {messaging} from "./firebaseconfig"
import Message from "./components/Message";
import "react-toastify/dist/ReactToastify.css";

function App() {
  const { VITE_APP_VAPID_KEY } = import.meta.env.VITE_APP_VAPID_KEY;
  onMessage(messaging, (payload) => {
    console.log(payload);
    if(payload.notification){
      toast(<Message notification={payload.notification} />);
    }
    else if (payload.data) {
      console.log(payload.data);
    }
    
  });

    async function requestPermission() {
      //requesting permission using Notification API
      const permission = await Notification.requestPermission();
  
      if (permission === "granted") {
        const token = await getToken(messaging, {
          vapidKey: VITE_APP_VAPID_KEY,
        });
  
        //We can send token to server
        console.log("Token generated : ", token);
      } else if (permission === "denied") {
        //notifications are blocked
        alert("You denied for the notification");
      }
    }
  
    useEffect(() => {
      requestPermission();
    }, []);
  
  return (
    <>
      <div>
        <h1>Hello</h1>
        <ToastContainer />
      </div>
    </>
  )
}

export default App

import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import {BrowserRouter} from "react-router-dom";
import Store from "./redStore/Store.jsx";
import {Provider} from "react-redux";
import {RecoilRoot} from "recoil";



createRoot(document.getElementById('root')).render(
    <Provider store={Store}>
        <RecoilRoot>
            <BrowserRouter>
                <StrictMode>
                    <App />
              </StrictMode>
            </BrowserRouter>
        </RecoilRoot>
    </Provider>
);


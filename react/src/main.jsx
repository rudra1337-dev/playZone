import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import {BrowserRouter} from "react-router-dom";
import Store from "./redStore/Store.jsx";
import {Provider} from "react-redux";
import {RecoilRoot} from "recoil";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";
import {ErrorWrapper} from "./Ecosystem.jsx"



const qClient = new QueryClient();


createRoot(document.getElementById('root')).render(
  <ErrorWrapper>
    <Provider store={Store}>
      <QueryClientProvider client={qClient}>
         <RecoilRoot>
           <BrowserRouter>
            <StrictMode>
              <App />
              </StrictMode>
            </BrowserRouter>
        </RecoilRoot>
      </QueryClientProvider>
    </Provider>
  </ErrorWrapper>
);


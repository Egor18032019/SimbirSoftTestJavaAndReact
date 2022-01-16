import logo from './logo.svg';
import './App.css';
import Main from "./Main.jsx"
import { AppRoute } from "./CONST.js"
import Realization from "./Realization.jsx"

import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
 import React, { useReducer } from 'react';

import { DataContext, initialState, dataReducer } from "./DataReducer"

function App() {
  const [state, dispatch] = useReducer(dataReducer, initialState);

  return (
    <DataContext.Provider value={{ dispatch, state }}>
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <a
          className="App-link"
          href="/"
        >
          <h1>
            Поиск и подсчет уникальных слов на сайте.
          </h1>
        </a>
        <a
          className="App-link"
          href="https://github.com/Egor18032019/SimbirSoftTestJavaAndReact"
          target="_blank"
          rel="noopener noreferrer"
        >
          Репозиторий
        </a>
      </header>
      <main>
        <BrowserRouter>
          <Routes>
            <Route path={AppRoute.ROOT} element={<Main />} />
            <Route path={AppRoute.REALIZATION} element={<Realization />} />
           </Routes>
        </BrowserRouter>
      </main>
    </div >
    </DataContext.Provider>
  );
}

export default App;

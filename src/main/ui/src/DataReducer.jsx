import React from "react";
import {Active, ReducerActionRouter} from "./CONST.js"

const DataContext = React.createContext("words");
const initialState = {
    active: Active.REALIZATION,
    result: [],
    url: "",
    status: ""
};


const dataReducer = (state, action) => {
    // eslint-disable-next-line default-case
    switch (action.type) {
        case ReducerActionRouter.GETUNICWORDS:
            const response = action.payload;
            const url = action.url;

            return Object.assign({}, state, {
                result: response,
                url: url,
                status: "words"
            })

        // Сохранили в ДБ и сбросили
        case ReducerActionRouter.SAVEINDB:

            return Object.assign({}, state, {
                result: [],
                status: ""
            })
    }
}

export {
    dataReducer,
    initialState,
    DataContext
};
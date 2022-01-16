import React from "react";
import { ReducerActionRouter, Active } from "./CONST.js"

const DataContext = React.createContext("words");
const initialState = {
    active: Active.REALIZATION,
    result: [],
    status: ""
};


const dataReducer = (state, action) => {
    // eslint-disable-next-line default-case
    switch (action.type) {
        case ReducerActionRouter.GETUNICWORDS:
            const response = action.payload;
     
             return Object.assign({}, state, {
                result: response,
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
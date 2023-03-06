import React, {useContext, useEffect, useRef, useState} from 'react';
import {DataContext} from "./DataReducer"

import {getMeUniqueWordFromThisSite, recUser} from "./Api.js"
import Cell from "./Cell.jsx"
import './Realization.css';
import {ReducerActionRouter} from "./CONST.js"

const Realization = () => {
    const {state, dispatch} = useContext(DataContext);

    let [cells, setcells] = useState([]);
    let [info, setinfo] = useState("Realization");
    let formRef = useRef(null);
    let siteRef = useRef(null);

    let unicwords = Object.keys(cells).length
    useEffect(() => {
        setcells(state.result)
    }, [state.result]);

    const sendUrlForParsing = (evt) => {
        evt.preventDefault();
        const userRequest = siteRef.current.value;
        setinfo(userRequest)
        getMeUniqueWordFromThisSite(userRequest).then(
            (data) => {
                dispatch({
                    type: ReducerActionRouter.GETUNICWORDS,
                    payload: data,
                    url: userRequest
                })
            }
        )
    }

    const saveWordInDB = (evt) => {
        evt.preventDefault();
        console.log("saveWordInDB ");
        recUser(cells,state.url);
        dispatch({
            type: ReducerActionRouter.SAVEINDB,
        });
        setinfo("You can new request.");
    }
    const _handleReset = () => {
        formRef = null
        setinfo("Realization")
        setcells({})
    }

    return (
        <div className="realization">
            <form className="realization-form" ref={formRef}>

                <fieldset className="realization-form__element">
                    <label className="realization-form__label" htmlFor="users">Адрес сайта: </label>
                    <input id="users" name="users" type="text" required ref={siteRef}/>
                </fieldset>

                <fieldset className="realization-form__element realization-form__element--submit">
                    <button className="ad-form__submit" type="submit" onClick={sendUrlForParsing}>Отправить</button>
                    или <button className="ad-form__reset" type="reset" onClick={_handleReset}>Очистить форму</button>
                </fieldset>
            </form>
            {unicwords > 0 ?
                <div>
                    <p>Количество уникальных слов - {unicwords}</p>
                    <button className="ad-form__clear" type="submit" onClick={saveWordInDB}>Сохранить в БД</button>
                </div>
                : ""}
            <h1>{info}</h1>
            <ul className="cell_list">
                {
                    Object.keys(cells).map(
                        (key, index) => {
                            return (
                                <Cell
                                    words={key}
                                    cell={cells[key]}
                                    key={key}
                                />
                            );
                        })
                }
            </ul>


        </div>

    )
}


export default Realization;
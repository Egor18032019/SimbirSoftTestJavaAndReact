import { AppRoute } from "./CONST.js"
import { Link } from "react-router-dom";

function Toolbar( ) {

    return (

        <div className="toolbar">

            <Link className="toolbar-link" to={AppRoute.REALIZATION}>
                <h2>- Реализация </h2>
            </Link> 
     
 
        </div>


    );
}

export default Toolbar;
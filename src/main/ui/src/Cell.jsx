
function Cell(props) {
    const {words,cell } = props;
     return (
        <li className="cell">
            <div className="cell_id">{words} </div>
            <div className="cell_name">{cell} </div>
        </li>
    )
};

export default Cell;
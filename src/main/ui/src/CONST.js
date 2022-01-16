const Active = {
    REALIZATION: "REALIZATION",
    TECHTASK : `TECHTASK`,
    TESTCASE: `TESTCASE`,
} 

const AppRoute = {
    ROOT: `/`,
    REALIZATION: `/realization`,
    TECHTASK : `/task`,
    TESTCASE: `/case`,
};

const ReducerActionRouter = {
    GETUNICWORDS : `GETUNICWORDS`,
    SAVEINDB: `SAVEINDB`, 
 
}

const Request = {
    GETWORDS : '/api/get',
    SAVEWORD: '/api/save', 
}

export {
    ReducerActionRouter,
    AppRoute,
    Active,
    Request
};
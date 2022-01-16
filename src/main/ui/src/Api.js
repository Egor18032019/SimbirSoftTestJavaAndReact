import {
    Request
} from "./CONST.js"

//  TODO сделать Енумы на `/api/get` и другие
async function getMeUniqueWordFromThisSite(data) {
    //  const url =  `${Request.GETWORDS}?url=${(new URLSearchParams(data)).toString()}`
    const url = `${Request.GETWORDS}?url=${data}`

    const response = await fetch(url);
    return await response.json();
}

async function recUser(data) {
    const response = await fetch(Request.SAVEWORD, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
 const answer =   response;
 console.log(answer)
    // return await response.json();
    return true;

}



export {
    getMeUniqueWordFromThisSite,
    recUser,
}
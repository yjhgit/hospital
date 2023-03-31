function userInfo(success,error=function (res){console.log('请求失败')}) {
    $.ajax({
        url: "/login/userInfo",
        method: 'get',
        success,
        error,
    })

}

function shoppingOnline(success,error=function (res){console.log('请求失败')}) {
    $.ajax({
        url: "/staffApi/IndexTopData",
        method: 'get',
        success,
        error,
    })

}

function systemInfo(success){
    $.ajax({
        url: "/login/toConfigure",
        method: 'get',
        success,
        error(res) {
            console.log('请求失败')
            console.log(res)
        },
    })
}

function loginByUser(data,success,error=function (res){console.log('请求失败')}){
    $.ajax({
        url: "/login/ByUser",
        method: 'post',
        data,
        success,
        error
    })
}


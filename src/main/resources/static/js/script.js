console.log("Script loadded");

let currentTheme =getTheme();

//TODO
function changeTheme()
{

}

//set theme to localstorage

function setTheme(theme)
{
    localStorage.setTheme("theme", theme);
}

//get theme from localstorage
function getTheme()
{
    let theme=localStorage.getItem("theme");
    if(theme)return theme;
    else return "light";
}

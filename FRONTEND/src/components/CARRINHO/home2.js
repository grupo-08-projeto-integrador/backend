export function hamburguerOnClick(event) {
  event.currentTarget.classList.toggle("change");
  document.getElementById("nav").classList.toggle("change");
  document.getElementById("menu-bg").classList.toggle("change-bg");
}

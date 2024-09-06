const addressList = {};

addressList["Google Drive"] = "https://drive.google.com/drive/u/0/folders/1AiOacBgHuUoHDMmF8YirNNJh0WCXRYxE";
addressList["Github"] = "https://github.com/khja240624";
addressList["Zoom"] = "https://zoom.us/j/7652500624?pwd=dndW4u3ViOzaV8482AiT3X7flowHXl.1";
addressList["KH 정보교육원"] = "https://kh-academy.co.kr/";
addressList["CodeTogether(Eclipse)"] = "https://live.codetogether.io/#/PFoAPW8OEANdR75RFcDcmW/tFVmHd69cO9fqXP61eyVly";
addressList["CodeTogether(VSCode)"] = "https://live.codetogether.io/#/12a5bc20-eb28-40aa-895e-10c4362afbfe/dcJIPL2YaXeEjv9jqVTBpU";
addressList["CodeTogether(DBeaver)"] = "";

const btns = document.querySelectorAll('a.button');

btns.forEach(btn => {
  btn.addEventListener('click', e => {
    e.preventDefault();
    const title = btn.innerText;

    const url = addressList[title];
    
    if(url === undefined || url === "") {
      alert("등록된 주소가 없습니다");
      return;
    }

    window.open(addressList[title]);
  })
})
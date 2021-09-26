let sortDirection = false;
let productData = [
    { productname: 'Clock', highestCurrentBid: '500', noOfBidders: '8', bidEndDate: '2021-09-23', imageNumber: '1' }, // comes from json data java
    { productname: 'Keyboard', highestCurrentBid: '5000', noOfBidders: '10', bidEndDate: '2021-09-28', imageNumber: '2' },
    { productname: 'Charger', highestCurrentBid: '1300', noOfBidders: '1', bidEndDate: '2021-09-22', imageNumber: '3' },
    { productname: 'Watch', highestCurrentBid: '4000', noOfBidders: '3', bidEndDate: '2021-09-20', imageNumber: '4' },
    { productname: 'Shoes', highestCurrentBid: '5500', noOfBidders: '2', bidEndDate: '2021-09-20', imageNumber: '5' },
];


window.onload = () => {
    loadTableData(productData)
};

function loadTableData(productData) {
    const tableBody = document.getElementById('tableData');
    let dataHTML = "<table><tr>";

    for (let product of productData) {
        dataHTML += "<td>" + product.productname + "</td><td>" + product.highestCurrentBid + "</td><td>" + product.noOfBidders + "</td><td>" + product.bidEndDate + "</td><td><img height='80px' width='80px' src='../tableImages/image" + product.imageNumber + ".jpg' /></td><td>" + "delete" + "</td></tr>";
    }
    dataHTML += "</tr></table>"

    console.log(dataHTML)
    tableBody.innerHTML = dataHTML;
}
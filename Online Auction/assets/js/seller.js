let sortDirection = false;
let productData = [
    { productname: 'Clock', highestCurrentBid: '50000', noOfBidders: '8', bidEndDate: '2021-09-23' },
    { productname: 'Keyboard', highestCurrentBid: '6000', noOfBidders: '10', bidEndDate: '2021-09-28' },
    { productname: 'Charger', highestCurrentBid: '13300', noOfBidders: '1', bidEndDate: '2021-09-22' },
    { productname: 'Watch', highestCurrentBid: '4090', noOfBidders: '3', bidEndDate: '2021-09-20' },
    { productname: 'Shoes', highestCurrentBid: '9500', noOfBidders: '2', bidEndDate: '2021-09-20' },
];

window.onload = () => { 
    loadTableData(productData)
};

function loadTableData(productData) {
    const tableBody = document.getElementById('tableData');
    let dataHTML = '';

    for (let product of productData) {
        dataHTML += "<tr><td>${ product.productname }</td><td>${ product.highestCurrentBid }</td><td>${ product.noOfBidders }</td><td>${ product.bidEndDate }</td><td></td></tr>";
    }
    console.log(dataHTML)
    tableBody.innerHTML = dataHTML;
}
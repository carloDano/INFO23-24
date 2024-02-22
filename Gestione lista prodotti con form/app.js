// Array per memorizzare i prodotti
let productList = [];

// Elementi del DOM
const productForm = document.getElementById('productForm');
const productListElement = document.getElementById('productList');

// Gestore di eventi per l'invio del modulo
productForm.addEventListener('submit', (event) => {
    event.preventDefault();
    addProduct();
});

// Funzione per aggiungere un prodotto
function addProduct() {
    const category = document.getElementById('category').value;
    const code = document.getElementById('code').value;
    const name = document.getElementById('name').value;
    const description = document.getElementById('description').value;
    const price = parseFloat(document.getElementById('price').value);
    const discount = document.querySelector('input[name="discount"]:checked') ? parseInt(document.querySelector('input[name="discount"]:checked').value) : 0;
    const inStock = document.getElementById('inStock').checked;

    const product = {
        category: category,
        code: code,
        name: name,
        description: description,
        price: price,
        discount: discount,
        inStock: inStock
    };

    productList.push(product);
    displayProduct(product);
    productForm.reset();
}

// Funzione per visualizzare un prodotto nella lista
function displayProduct(product) {
    const listItem = document.createElement('li');
    listItem.className = 'productItem';
    listItem.innerHTML = `
        Codice: ${product.code} - Nome: ${product.name} - Prezzo: ${product.price}
        <button onclick="editProduct('${product.code}')">Modifica</button>
        <button onclick="removeProduct('${product.code}')">Rimuovi</button>
    `;
    productListElement.appendChild(listItem);
}

// Funzione per rimuovere un prodotto
function removeProduct(code) {
    productList = productList.filter(product => product.code !== code);
    displayProducts();
}

// Funzione per visualizzare tutti i prodotti nella lista
function displayProducts() {
    productListElement.innerHTML = '';
    productList.forEach(product => {
        displayProduct(product);
    });
}

// Inizializzazione della visualizzazione dei prodotti
displayProducts();

// Funzione per modificare un prodotto
function editProduct(code) {
    const product = productList.find(product => product.code === code);
    if (product) {
        document.getElementById('category').value = product.category;
        document.getElementById('code').value = product.code;
        document.getElementById('name').value = product.name;
        document.getElementById('description').value = product.description;
        document.getElementById('price').value = product.price;
        document.getElementById('inStock').checked = product.inStock;

        const discountRadios = document.getElementsByName('discount');
        discountRadios.forEach(radio => {
            if (parseInt(radio.value) === product.discount) {
                radio.checked = true;
            }
        });

        // Rimuovi il prodotto dalla lista
        removeProduct(code);
    }
}

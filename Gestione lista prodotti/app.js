// Inizializza un array vuoto per i prodotti
let prodotti = [];

// Funzione per mostrare i prodotti nella pagina
function showProducts() {
  const productListDiv = document.getElementById("product-list");
  productListDiv.innerHTML = ""; // Pulisci il contenuto precedente

  // Itera attraverso l'array dei prodotti e crea gli elementi da visualizzare
  prodotti.forEach((prodotto) => {
    const prodottoDiv = document.createElement("div");
    prodottoDiv.textContent = `Codice: ${prodotto.codice}, Nome: ${prodotto.nome}, Prezzo: ${prodotto.prezzo}`;
    productListDiv.appendChild(prodottoDiv);
  });
}

// Funzione per aggiungere un nuovo prodotto
function addProduct() {
  // Implementa la logica per aggiungere un prodotto all'array
  // E aggiorna la visualizzazione chiamando showProducts()
}

// Funzione per rimuovere un prodotto
function deleteProduct() {
  // Implementa la logica per rimuovere un prodotto dall'array
  // E aggiorna la visualizzazione chiamando showProducts()
}

// Funzione per ordinare la lista di prodotti
function sortProducts() {
  // Implementa la logica per ordinare l'array dei prodotti
  // E aggiorna la visualizzazione chiamando showProducts()
}

// Chiamata iniziale per mostrare i prodotti
showProducts();

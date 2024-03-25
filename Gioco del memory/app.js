class MemoryGame {
    constructor(cardCount) {
        this.cardCount = cardCount;
        this.cards = [];
        this.attempts = 0;
        this.selectedCards = [];

        this.gameContainer = document.getElementById('game-container');
        this.statsContainer = document.getElementById('stats-container');
        this.totalAttemptsSpan = document.getElementById('total-attempts');

        this.createGame();
    }

    createGame() {
        for (let i = 1; i <= this.cardCount / 2; i++) {
            for (let j = 0; j < 2; j++) {
                const card = document.createElement('div');
                card.className = 'card';
                card.textContent = i;
                card.addEventListener('click', () => this.cardClick(card));
                this.cards.push(card);
            }
        }

        this.shuffleCards();
        this.cards.forEach(card => this.gameContainer.appendChild(card));
    }

    shuffleCards() {
        for (let i = this.cards.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [this.cards[i], this.cards[j]] = [this.cards[j], this.cards[i]];
        }
    }

    cardClick(card) {
        if (this.selectedCards.length < 2 && !this.selectedCards.includes(card) && !card.classList.contains('flipped')) {
            card.classList.add('flipped');
            this.selectedCards.push(card);

            if (this.selectedCards.length === 2) {
                this.attempts++;
                setTimeout(() => this.checkMatch(), 1000);
            }
        }
    }

    checkMatch() {
        const [card1, card2] = this.selectedCards;
        if (card1.textContent === card2.textContent) {
            this.selectedCards = [];
            if (this.cards.every(card => card.classList.contains('flipped'))) {
                this.endGame();
            }
        } else {
            setTimeout(() => {
                this.selectedCards.forEach(card => card.classList.remove('flipped'));
                this.selectedCards = [];
            }, 1000);
        }
    }

    endGame() {
        this.statsContainer.style.display = 'block';
        this.totalAttemptsSpan.textContent = this.attempts;
    }
}

const cardCount = 12; // Change this to your desired number of cards
const game = new MemoryGame(cardCount);

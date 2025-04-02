const symbols = ['🌱', '🌹	', '🍒', '🍇', '🍉', '🍓', '🥝', '🍍','🌵','🍁'];
let cards = [];
let score = 0;
let timer = 0;
let timerInterval;
let canFlip = true;

let flippedCards = []


function initializeGame() {
    cards = symbols.concat(symbols).sort(() => Math.random() - 0.5);
    renderCards();
    startTimer(); 
  }

  function startTimer() {
    timerInterval = setInterval(() => {
      const minutes = Math.floor(timer / 60); 
      const seconds = timer % 60; 
      
      
      document.getElementById('timer').textContent = `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
      
     
      const durationInSeconds = 120; 
      if (timer === durationInSeconds) {
        clearInterval(timerInterval); 
        alert('Game Over! Time is up.'); 
      }
      
      timer++; 
    }, 1000); 
  }
function renderCards() {
    const gameBoard = document.getElementById('game-board');
    gameBoard.innerHTML = '';
    cards.forEach((symbol, index) => {
      const card = document.createElement('div');
      card.classList.add('card');
      card.dataset.index = index;
      card.addEventListener('click', flipCard);
      gameBoard.appendChild(card);
    });
  }
  
  function flipCard() {
    if (!canFlip) return;
    const index = parseInt(this.dataset.index);
    if (this.classList.contains('flipped')) return;
    this.classList.add('flipped');
    
    
    this.textContent = cards[index];
  
    flippedCards.push(this);
  
    if (flippedCards.length === 2) {
     
      const [card1, card2] = flippedCards;
      const index1 = parseInt(card1.dataset.index);
      const index2 = parseInt(card2.dataset.index);
  
      if (cards[index1] === cards[index2]) {
        
        score++;
        document.getElementById('score').textContent = score;
        if (score === symbols.length) {
          clearInterval(timerInterval);
          alert('Congratulations! You won!');
        }
        flippedCards = []; 
      } else {
       
        canFlip = false; 
        setTimeout(() => {
          card1.classList.remove('flipped');
          card2.classList.remove('flipped');
          card1.textContent = ''; 
          card2.textContent = ''; 
          canFlip = true; 
          flippedCards = []; 
        }, 1000);
      }
    }
  
  }
  function resetGame() {
    clearInterval(timerInterval);
    cards = [];
    score = 0;
    timer = 0;
    document.getElementById('score').textContent = score;
    document.getElementById('timer').textContent = timer;
    initializeGame();
  }

initializeGame();
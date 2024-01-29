const canvas = document.getElementById('palleCanvas');
const ctx = canvas.getContext('2d');

const w = canvas.width = window.innerWidth;
const h = canvas.height = window.innerHeight;

const cerchi = [
    { x: w / 4, y: h / 4, raggio: 20, colore: 'red', vx: 2, vy: 1 },
    { x: 3 * w / 4, y: h / 4, raggio: 20, colore: 'yellow', vx: -2, vy: 1 },
    { x: w / 4, y: 3 * h / 4, raggio: 20, colore: 'green', vx: 2, vy: -1 },
    { x: 3 * w / 4, y: 3 * h / 4, raggio: 20, colore: 'blue', vx: -2, vy: -1 },
];

function draw() {
    ctx.clearRect(0, 0, w, h);

    for (const cerchio of cerchi) {
        ctx.beginPath();
        ctx.arc(cerchio.x, cerchio.y, cerchio.raggio, 0, Math.PI * 2);
        ctx.fillStyle = cerchio.colore;
        ctx.fill();
        ctx.closePath();
    }

    requestAnimationFrame(draw);
}

function update() {
    for (const cerchio of cerchi) {
        cerchio.x += cerchio.vx;
        cerchio.y += cerchio.vy;

        // Rimbalzo sulle pareti
        if (cerchio.x - cerchio.raggio < 0 || cerchio.x + cerchio.raggio > w) {
            cerchio.vx *= -1;
        }

        if (cerchio.y - cerchio.raggio < 0 || cerchio.y + cerchio.raggio > h) {
            cerchio.vy *= -1;
        }

        // Rimbalzo sulle altre palle
        for (const altroCerchio of cerchi) {
            if (cerchio !== altroCerchio) {
                const distanza = Math.hypot(cerchio.x - altroCerchio.x, cerchio.y - altroCerchio.y);
                const sommaRaggi = cerchio.raggio + altroCerchio.raggio;

                if (distanza < sommaRaggi) {
                    // Collisione, inverti le velocità
                    const angolo = Math.atan2(cerchio.y - altroCerchio.y, cerchio.x - altroCerchio.x);
                    const vx1 = cerchio.vx * Math.cos(angolo) + cerchio.vy * Math.sin(angolo);
                    const vy1 = cerchio.vy * Math.cos(angolo) - cerchio.vx * Math.sin(angolo);
                    const vx2 = altroCerchio.vx * Math.cos(angolo) + altroCerchio.vy * Math.sin(angolo);
                    const vy2 = altroCerchio.vy * Math.cos(angolo) - altroCerchio.vx * Math.sin(angolo);

                    cerchio.vx = vx2;
                    cerchio.vy = vy2;
                    altroCerchio.vx = vx1;
                    altroCerchio.vy = vy1;
                }
            }
        }
    }

    requestAnimationFrame(update);
}

draw();
update();

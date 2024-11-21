document.addEventListener('DOMContentLoaded', (event) => {
    const scrollContainer = document.querySelector('.scroll-container');
    const scrollAmount = 25; // Adjust this value to control scroll amount
    let currentScrollPosition = 0;

    document.querySelector('.scroll-left').addEventListener('click', () => {
        currentScrollPosition += scrollAmount;
        if (currentScrollPosition > 0) {
            currentScrollPosition = 0;
        }
        scrollContainer.style.transform = `translateX(${currentScrollPosition}%)`;
    });

    document.querySelector('.scroll-right').addEventListener('click', () => {
        currentScrollPosition -= scrollAmount;
        if (Math.abs(currentScrollPosition) >= scrollContainer.scrollWidth - scrollContainer.clientWidth) {
            currentScrollPosition = -(scrollContainer.scrollWidth - scrollContainer.clientWidth);
        }
        scrollContainer.style.transform = `translateX(${currentScrollPosition}%)`;
    });
});

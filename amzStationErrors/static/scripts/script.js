document.addEventListener("DOMContentLoaded", function(){
  // Select all thumbnail images
  const thumbnails = document.querySelectorAll('.thumbnail');
  const modal = document.getElementById('imageModal');
  const modalImg = document.getElementById('modalImage');
  const closeBtn = document.getElementById('closeModal');

  // When a thumbnail is clicked, open the modal and set the full image source.
  thumbnails.forEach(thumbnail => {
    thumbnail.addEventListener('click', function() {
      const fullImageUrl = this.getAttribute('data-full');
      if (fullImageUrl) {
        modal.style.display = 'block';
        modalImg.src = fullImageUrl;
      } else {
        console.error('Full image URL not found for:', this);
      }
    });
  });

  // Close the modal when the close button is clicked.
  closeBtn.addEventListener('click', function() {
    modal.style.display = 'none';
    modalImg.src = ''; // Clear the source
  });

  // Also close the modal if the user clicks anywhere outside the image.
  modal.addEventListener('click', function(e) {
    if (e.target === modal) {
      modal.style.display = 'none';
      modalImg.src = '';
    }
  });
});
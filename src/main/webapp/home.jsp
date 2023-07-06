<div class="chat-home">
  <div class="chat-header">
    <h2>Chat App</h2>
    <div class="search-wrapper">
  <input type="text" class="search-box" placeholder="Search...">
  <button type="submit" class="search-button"><i class="fa fa-search"></i></button>
</div>

  </div>
  <link rel="stylesheet" href="style.css" />

  

<script>
  const searchBox = document.querySelector('.search-box');

searchBox.addEventListener('focus', () => {
  searchBox.parentNode.classList.add('active');
});

searchBox.addEventListener('blur', () => {
  if (searchBox.value == '') {
    searchBox.parentNode.classList.remove('active');
  }
});
</script>
let mainPosts = document.querySelectorAll(".main-post");
let posts = document.querySelectorAll(".post");

let i = 0;
let postIndex = 0;
let currentPost = posts[postIndex];
let currentMainPost = mainPosts[postIndex];

let progressInterval = setInterval(progress, 100); // 180

function progress() {
  if (i === 100) {
    i = -5;
    // reset progress bar
    if (currentPost) {
      currentPost.querySelector(".progress-bar__fill").style.width = 0;
      currentPost.classList.remove("post--active");
    }
    document.querySelector(".progress-bar--primary .progress-bar__fill").style.width = 0;

    postIndex++;

    if (currentMainPost) {
      currentMainPost.classList.add("main-post--not-active");
      currentMainPost.classList.remove("main-post--active");
    }

    // reset postIndex to loop over the slides again
    if (postIndex === posts.length) {
      postIndex = 0;
    }

    currentPost = posts[postIndex];
    currentMainPost = mainPosts[postIndex];
  } else {
    i++;
    if (currentPost) {
      currentPost.querySelector(".progress-bar__fill").style.width = `${i}%`;
      currentPost.classList.add("post--active");
    }
    document.querySelector(".progress-bar--primary .progress-bar__fill").style.width = `${i}%`;

    if (currentMainPost) {
      currentMainPost.classList.add("main-post--active");
      currentMainPost.classList.remove("main-post--not-active");
    }
  }
}

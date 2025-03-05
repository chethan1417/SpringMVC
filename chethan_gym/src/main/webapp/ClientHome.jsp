<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gym Home Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #2c2c2c;
            border-bottom: 2px solid #333;
            padding: 10px 0;
        }

        header h1 {
            font-size: 2.5rem;
            font-weight: 700;
            color: #f0a500;
            text-transform: uppercase;
            letter-spacing: 2px;
            margin-bottom: 20px;
        }

        nav ul {
            padding: 0;
            margin: 0;
            list-style: none;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        nav ul li {
            margin-right: 30px;
        }

        nav ul li:last-child {
            margin-right: 0;
        }

        nav a {
            color: #fff;
            font-size: 1.1rem;
            font-weight: 500;
            text-transform: uppercase;
            letter-spacing: 1px;
            padding: 8px 15px;
            display: inline-block;
            transition: color 0.3s ease, transform 0.3s ease;
            text-decoration: none;
        }

        nav a:hover {
            color: #f0a500;
            transform: scale(1.1);
        }

        nav a.active {
            color: #f0a500;
        }

        .navbar-toggler {
            border-color: #f0a500;
        }

        .navbar-toggler-icon {
            background-color: #f0a500;
        }

        .program-section {
            background: url('https://source.unsplash.com/1600x900/?gym,workout') no-repeat center center/cover;
            padding: 100px 0;
            text-align: center;
            color: white;
        }

        .program-section .container {
            background: rgba(255, 255, 255, 0.85);
            padding: 50px 20px;
            border-radius: 15px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.2);
        }

        .program-section h2 {
            font-size: 2.5rem;
            font-weight: 700;
            color: #2c2c2c;
            margin-bottom: 30px;
        }

        .program-section p {
            font-size: 1.2rem;
            color: #555;
            margin-bottom: 40px;
        }


        .program-content {
            background: #2c2c2c;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .program-content:hover {
            transform: translateY(-10px);
            box-shadow: 0px 15px 30px rgba(0, 0, 0, 0.2);
        }

        .program-content img {
            width: 100%;
            height: 300px;
            object-fit: cover;
            border-radius: 10px;
            margin-bottom: 15px;
        }

        .program-content h3 {
            font-size: 1.8rem;
            font-weight: 600;
            color: #2c2c2c;
            margin-bottom: 20px;
        }

        .program-content p {
            font-size: 1.1rem;
            color: #333;
        }

        /* Mobile Adjustments */
        @media (max-width: 767px) {
            .program-section h2 {
                font-size: 2rem;
            }

            .program-section p {
                font-size: 1.1rem;
            }

            .program-content {
                padding: 20px;
            }
        }

        /* Footer Styling */
        footer {
            background-color: #2c2c2c;
            padding: 30px 20px;
            text-align: center;
            color: white;
            font-size: 1rem;
            border-top: 2px solid #333;
        }

        /* Hero Section */
        .hero {
            background: url('https://source.unsplash.com/1600x900/?gym,fitness') no-repeat center center/cover;
            padding: 100px 20px;
            color: white;
            text-align: center;
        }

        .hero h2 {
            font-size: 3rem;
            font-weight: bold;

        }

        .hero p {
            font-size: 1.2rem;

        }

        .service-img {
            height: 400px;
            object-fit: cover;
        }


       #testimonials img {
           max-width: 300px;
           height: auto;
           display: block;
           margin: 0 auto;
       }

#login,
#programs,
#services,
#testimonials,
#contact {
    padding: 5px 5px;
}

.program-section {
    padding: 60px 0;
}

.hero {
    padding: 70px 20px;
}



.login-section .row {
    margin-top: 50px;
}

.login-section .btn {
    margin-top: 15px;
}

            .fade-in {
                opacity: 0;
                transform: translateY(30px);
                transition: opacity 0.8s ease-out, transform 0.8s ease-out;
            }
            .fade-in.show {
                opacity: 1;
                transform: translateY(0);
            }

            .btn {
                transition: all 0.3s ease;
            }
            .btn:hover {
                transform: scale(1.1);
            }

            .img-fluid:hover {
                transform: scale(1.05);
                transition: transform 0.3s ease;
            }

            html {
                scroll-behavior: smooth;
            }

.video-background {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
    z-index: -1;
}

.video-element {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.transparent-bg {
    background: transparent !important;
    backdrop-filter: none;
}

.text-white {
    color: white !important;
}

            .video-overlay {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: rgba(0, 0, 0, 0.5); /* Dark transparent overlay */
                z-index: -1;
            }

            /* Adjust login section */
            .login-section {
                position: relative;
                padding: 100px 20px;
                color: white;
            }

           #login {
               position: relative;
               height: 100vh; /* Full-screen height */
               overflow: hidden;
           }

           /* Background Video Styling */
           .video-background {
               position: absolute;
               top: 0;
               left: 0;
               width: 100%;
               height: 100%;
               overflow: hidden;
               z-index: -1;
           }

           .video-background video {
               width: 100%;
               height: 100%;
               object-fit: cover;
           }

           .login-section {
               position: absolute;
               top: 10%;
               left: 50%;
               transform: translateX(-50%);
               text-align: center;
               width: 100%;
               background: transparent !important; /* Ensures transparency */
           }

           /* Login Buttons */
           .login-section .btn {
               transition: all 0.3s ease;
               font-size: 1.2rem;
               padding: 12px 25px;
               margin: 5px;
           }

           .login-section .btn:hover {
               transform: scale(1.1);
           }

           .login-section h6 {
               margin-top: 1px;
               font-size: 1rem;
               color: white;
           }

           footer {
               background-color: #2c2c2c;
               padding: 30px 20px;
               text-align: center;
               color: white;
               font-size: 1rem;
               border-top: 2px solid #333;
           }

    </style>
</head>
<body>
    <header class="bg-dark text-white text-center p-4">
        <h1>WELCOME , ${registrationEntity.name}</h1>
        <nav>
            <ul class="nav justify-content-center">
<li class="nav-item">
    <a class="nav-link text-white" href="http://localhost:8080/chethan_gym/userDetails?email=${registrationEntity.email}">Profile</a>
</li>
                <li class="nav-item"><a class="nav-link text-white" href="#programs">Programs</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="#services">Services</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="#testimonials">Review</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="#contact">Contact</a></li>
            </ul>
        </nav>
    </header>

    <section id="login" class="login-section text-center text-dark position-relative">
        <!-- Background Video -->
        <div class="video-background">
            <video autoplay muted loop playsinline>
                <source src="https://resource.flexclip.com/templates/video/720p/text-effects-sports-intro.mp4?v=1.0.6.8.1" type="video/mp4">
                Your browser does not support the video tag.
            </video>
            <iframe
                src="https://www.youtube.com/embed/tUykoP30Gb0?start=3&autoplay=1&mute=1&loop=1&playlist=tUykoP30Gb0&controls=0&showinfo=0&modestbranding=1"
                frameborder="0"
                allow="autoplay; encrypted-media"
                allowfullscreen>
            </iframe>
        </div>

        <!-- Overlay to Improve Readability -->
        <div class="video-overlay"></div>


        </div>
    </section>


    <section id="programs" class="program-section text-center text-dark">
        <div class="container">
            <h2 class="fw-bold text-black mb-4">Our Programs</h2>
            <p class="text-black">The diverse range of programs, from group exercises to corporate training and personalized training, caters to varying fitness levels and goals. Personalized training programs ensure workouts are tailored to individual needs, maximizing results. Join us and achieve your fitness goals with our expert guidance!</p>

            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4 mb-4">
                    <div class="program-content p-4 rounded shadow">
                        <img src="https://img.fitimg.in/cdn/web-assets/images/home/fitpass-tv-slider.png?format=webp&w=768&dpr=1.3" class="img-fluid rounded mb-3" alt="Gym Program">
                        <h3 class="fw-bold text-white">Online Training</h3>
                        <p class="text-white">"Join our virtual training sessions with real-time feedback and motivation from experienced trainers. Programs tailored to all fitness levels."</p>
                    </div>
                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                                    <div class="program-content p-4 rounded shadow">
                                        <img src="https://www.healthstatus.com/wp-content/uploads/2021/03/exercise-gym-trainer-weights.jpg" class="img-fluid rounded mb-3" alt="Gym Program">
                                        <h3 class="fw-bold text-white">Personal Training</h3>
                                        <p class="text-white">"Join our virtual training sessions with real-time feedback and motivation from experienced trainers. Programs tailored to all fitness levels."</p>
                                    </div>
                                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                    <div class="program-content p-4 rounded shadow">
                        <img src="https://wallpaperbat.com/img/8676144-workout-wallpaper-4k-limitless.jpg" class="img-fluid rounded mb-3" alt="Gym Program">
                        <h3 class="fw-bold text-white">Corporate Membership</h3>
                        <p class="text-white">"We bring the gym to you! Our corporate memberships include fitness activities, wellness seminars, and more to help your team stay healthy."</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="services" class="text-center p-5">
        <h2 class="fw-bold text-black mb-4">Our Services</h2>
        <div class="row">
            <div class="col-md-4">
                <div class="p-3 border rounded shadow">
                    <img src="https://i0.wp.com/goldsgym.in/wp-content/uploads/2023/11/Personal-training-1.jpg?resize=768%2C512&ssl=1" class="img-fluid rounded service-img" alt="Personal Training">
                    <p class="text-black">Personal Training</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="p-3 border rounded shadow">
                    <img src="https://i0.wp.com/goldsgym.in/wp-content/uploads/2023/11/Group-Program-1.jpg?resize=768%2C512&ssl=1" class="img-fluid rounded service-img" alt="Group Classes">
                    <p class="text-black" >Group Classes</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="p-3 border rounded shadow">
                    <img src="https://img.fitimg.in/cdn/web-assets/images/home/fitfeast.png?format=webp&w=360&dpr=1.3" class="img-fluid rounded service-img" alt="Nutrition Plans">
                    <p class="text-black">Nutrition Plans</p>
                </div>
            </div>
        </div>
    </section>

    <section id="testimonials" class="bg-light p-5">
        <h2 class="text-center">What Our Clients Say</h2>
                            <img src="https://lafayettefamilyymca.org/wp-content/uploads/2022/12/154039116_m.jpg" class="img-fluid rounded" alt="Nutrition Plans">

        <p class="text-center">"This Gym has completely transformed my fitness journey. The trainers are top-notch and the community is motivating!" - Client Testimonial</p>
    </section>

    <section id="contact" class="text-center p-5">
        <h2>Contact Us</h2>
        <p>Email: <span style="color: blue;">cgyms@gmail.com</span></p>
        <p>Phone: <span style="color: blue;">+91 8548866698 | 7411971417</span></p>
    </section>


    <footer>
        <h4>Visit Us</h4>
                <p> Iron Pulse Rajajinagar , FlexFit BTM , Titan Strength Indiranagar , Forge Fitness HSR Layout , Peak Fitness JP Nagar</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

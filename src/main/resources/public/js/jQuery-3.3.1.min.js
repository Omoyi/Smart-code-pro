TweenMax.to(".title-1", 2, {
            x: 30,
            opacity: 1,
            ease: Expo.easeInOut

        });
        TweenMax.to(".title-2", 2, {
            delay: 0.2,
            x: -80,
            opacity: 1,
            ease: Expo.easeInOut

        });
        TweenMax.from(".runner", 2, {
            delay: 1.6,
            x: -80,
            opacity: 0,
            ease: Expo.easeInOut

        });
        TweenMax.from(".box-1", 4, {
            delay: 1,
            rotation: 200,
            transformOrigin: "50% 50%",
            opacity: 0,
            x: -180,
            ease: Expo.easeInOut
        });

        TweenMax.from(".box-2", 4, {
            delay: 1.2,
            rotation: 90,
            transformOrigin: "50% 50%",
            opacity: 0,
            x: -180,
            ease: Expo.easeInOut
        });
        TweenMax.from(".box-3", 4, {
            delay: 1,
            rotation: 180,
            transformOrigin: "50% 50%",
            opacity: 0,
            x: -180,
            ease: Expo.easeInOut
        });
        TweenMax.from(".pattern", 2, {
            delay: 0.8,
            opacity: 0,
            width: 0,
            ease: Expo.easeInOut

        });
        TweenMax.from(".logo", 2, {
            delay: 1.6,
            y: 20,
            opacity: 0,
            ease: Expo.easeInOut
            });

        TweenMax.staggerFrom(".menu ul li",2,{
           opacity:0,
           delay:1.6,
           y:20,
           ease:Expo.easeInOut
            },0.1);

            TweenMax.from(".cart", 2, {
            delay: 1.7,
            y: 20,
            opacity: 0,
            ease: Expo.easeInOut
            });
            TweenMax.staggerFrom(".media ul li", 2, {
            delay: 2,
            y: 20,
            opacity: 0,
            ease: Expo.easeInOut
      }, 0.1);

        TweenMax.from(".content", 2, {
            delay: 2.4,
            opacity: 0,
            y:20,
            ease: Expo.easeInOut

        });
        TweenMax.from(".content button", 2, {
            delay: 2.6,
            opacity: 0,
            y:20,
            ease: Expo.easeInOut

        });


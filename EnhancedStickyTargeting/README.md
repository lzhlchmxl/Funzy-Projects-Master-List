# Enhanced Sticky Targeting [School Project]

## Introduction
   - Enhanced Sticky Targeting is a improved version of [Cursor Sticky Targets](https://pdfs.semanticscholar.org/0383/4d0a637a65fc4de152ba1861b6630d113f5b.pdf)
   - The project is developed using [Processing](https://processing.org/) written in a Java-like object oriented language.
   - The project was completed with the help from **Ping Zhang** and **Charlotte Zhang**  in my **forth year** into coding.
   - Noticible skils involved: *Java-like Processing Language, Human-computer Interaction Design.*
   
## Installation
   - Download the .pde file
   - [Install Processing](https://processing.org/download/)
   - Open the .pde file with Processing and run the application
   
## Background

Throughout the term, we dedicated large amount of time for exploring virtual one-dimensional pointing in graphical user interfaces. A sticky targeting technique was implemented to help users to improve pointing performance. The strategy for one-dimensional sticky technique is to simply adjust CD-gain and make the cursor statically move slower within the target area. The classic sticky targeting approach, to some extend, helps users to finish pointing tasks. To further improve the classic sticky targeting approach, we combined the above experiences with HCI design knowledge acquired from class by creating and evaluating a new two-dimensional targeting technique. 

Targeting in a two-dimensional environment has two problems. One issue is the user may overshoot the target, and the other is when the cursor is approaching the target, the user intends to slow down and waste much time. Therefore, the goal of the current study is to make a better version of sticky target technique by improving the targeting time while minimizing the overshooting effect.

One of the limitations to the classic sticky technique is that there is no prevention for overshooting effect for two dimensional targets system.  As performing a pointing task, overshooting effect occurs when the mouse movement speed is too fast to stay within the target or the angle is off the target and miss the target. In two-dimensional targets system, overshooting becomes a more severe issue than one dimension because users may entirely miss a two-dimensional target without triggering the sticky effect

The other issue we have taken into consideration is due to human factors while performing pointing tasks. During a targeting performance, users always tend to speed up mouse movement at the beginning and slow down as the cursor approaches the target. If a user slows down the cursor too early, then the time is wasted for deceleration; if a user slow down too late, then the overshooting effect occurs. The human limitation will cause  time waste, overshooting effect, or both.

## Description of the system

To solve the two major issues, we came up with an enhanced sticky targeting technique. Our design concepts lead to our solution: a dynamic sticky field around the target. To avoid overshooting, the sticky field is generated at the moment when the mouse is clicked. The size of the sticky field is determined by the distance from the cursor to the target. As the distance increase, the size of the sticky filed increases. Within the sticky field, the CD-gain is adjusted dynamically based on the current distance from the cursor to the center of the target. Therefore, mouse movement speed is slower when getting closer to the target center. When the cursor reaches the target center, the cursor obtains an initial movement speed on both x and y coordination. Therefore, the cursor will move towards the target center.

In order to compensate the time wasted due to deceleration within the sticky field, the cursor is designed to accelerate when it is outside of the sticky field. Therefore, the CD-gain outside of the sticky field is increased to make up the time wasted.

However, under certain circumstances, overshooting still can occur. When users overshoot, a new sticky field is set to the target itself to reduce the time lost by moving the cursor backwards to click the target.



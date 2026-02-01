## NOTICE

This repository contains the public FTC SDK for the DECODE (2025-2026) competition season.

## Welcome!
This GitHub repository contains the source code that is used to build an Android app to control a *FIRST* Tech Challenge competition robot, forked from the FTCRobotController Repository. If you are new to programming, please read the following sections.

## Rules and Regulations of Repository 
Below are the rules for this repository. 

"The programming approach before Qual 3 wasn’t great. As such, this document is for allowing us to program better as a department for regionals." - Rachel

## 1. Branches
We have branches—we are supposed to actually use them (myself included). There will be no direct coding in the master branch. If there is any confusion as to why we will now have this rule, look at the commit history for 1/17/26 (aka code conflicts breaking things). Everyone must write their code in their own branch. 

## 2. Distribution of Workload
Having one person do everything eventually backfires. As such, everyone must work on an implementation of all parts of the code to increase the probability that at least some of it works. Everyone must be included in the programming process.

## 3. Discussion of Work before Implementation
Because we are working in separate branches, there will be potential differences in the approaches we take to solve a problem. So, we need to discuss what each of our programs should do so we all can solve the bugs we encounter, and that we are all on the same page. In addition, this allows us to utilize the best of each implementation to reach a more optimal solution. A one-off suggestion from someone else can greatly help the functionality of the robot (see changing revolver controls from a boolean to a double before Qual 3).

## 4. New Implementation Process
When a feature is being added to the code, the department must discuss the feature first. We will decide on a specific method heading and file location for the feature to better allow changing between different programmers’ implementations. Then, each programmer will implement their own version of the feature and test. The best implementation or combination of implementations will be added to the master branch, with the rest being added to a backup branch.

Follow https://docs.google.com/document/d/17wvY16y95ps48IQkGa5fy_QZE2hcO3W2o9SGdJvy0ls/edit?tab=t.0 to find the related flowchart for this rule.

## 5. Bugs
If any issue of any magnitude is found during testing, all other programmers must be notified immediately. It must be assumed that any error that can happen will happen at every possible opportunity at competition. Bugs cannot be ignored. All programmers must work together to remove any bugs from implementation as soon as possible.

## 6. Backup Code and Plans
All code must be committed to GitHub. While this cannot be done as school, it must be done frequently and in a timely manner to allow other programmers to see what is being changed in the code. Any basic opMode code that is strictly necessary for robot functioning must be kept in its own class. When more complex features are added to the code, they must be in a different class from the base code and have at least one basic backup. More complex backups are also recommended. When features are written, other implementations will be added to a backup code branch to be used if the primary implementation breaks, but this does not count as either the recommended or required backups, although it is required.

## 7. Encoders
We need to figure out how to actually use encoders properly. We all saw how awful the controls were on the Qual 3 robot, and we will probably need to use encoders again. Even if we don’t have to, it’s a useful thing that we probably should know. 

## 8. Comments and Naming
This one is relatively minor. Comments would probably be good to have, but we use self-documenting code a lot, and use generally the same rules for naming things already. However, naming rules take precedence over regular names of controllers (please do not capitalize the first letter of variable names starting with dpad). Just keep naming things well, although we will probably have to standardize variable names between us. 

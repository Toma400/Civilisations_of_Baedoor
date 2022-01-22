/**
 * HERE THERE WILL BE INFORMATION ON WHAT YOU NEED TO KEEP IN MIND WHILE WORKING ON FEATURES (reminder for me + info for people using remote workspace)
 * 
 * A lot of elements in CoB is yet placeholders, so if you do not understand why this thing exist - maybe it is because it should not. I'm testing things due to early stage of CoB development.
 * This may result on me getting more knowledgeable about generation specifics, so I can make mod better in further development. Do not worry about that.
 * 
 * [FOLDER NAMES]
 * 
 * Pds - procedures
 * 
 * 
 * [ENTITY ADDING]
 * 
 * 1. Try using ambient type + conditions, not monster/creature type. CoB will try to make mobcaps configurable, and ambient is easiest way to do that.
 * 
 * 2. Use custom spawning conditions (desert_mob_conditioning is general for all Dune-related animals, for example)
 *  
 * 3. Include mobs in mobcap lists, like Tag desert_animals_mobcap (for animals).
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * [LIST OF PROCEDURES THAT ARE DEPENDENT ON FILE MANAGER]
 * This is important due to changes for FM made on 2021.3, and for any further changes throughout MCR use.
 * ____________________________
 * HIRING | EMPIRE MANAGEMENT:
 * - !PlayerDataImport [creating & importing Empire costs + targets]
 * 		- !MonthlyCostCounter [dependent; makes each player count their month and activates payout on the end of it]
 * - EmpireInfoGet [in-game checking system for Empire stats]
 * 
 * - HiringSystem
 * - Hiring-related triggers:
 * 		- HiringCost
 * 		- DisbandmentCost
 * 		- DeathDisbandmentCost
 * 
 * - !Config Manager
 * 
 * ["!" indicates procedures on global triggers, CM and PDI are bound to PreConfigManager procedure]
*/
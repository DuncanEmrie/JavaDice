import random

#Change the value of these if you want:

enemy_hp = 100
dmg = 10
crit = 2
sides_on_dice = 20
attempts = 1000000

#Don't change these

success = 0
fail = 0
last_hit_was_crit = False

while success + fail < attempts:
    hp = enemy_hp

    while hp > 0:
        rand = random.randint(1, sides_on_dice)
        if rand == 1:
            last_hit_was_crit = True
            hp -= dmg*crit
        else:
            last_hit_was_crit = False
            hp -= dmg
    if last_hit_was_crit:
        success += 1
    else:
        fail += 1
    #print(last_hit_was_crit)

print("Chance of imp dropping a diamond, approx: " + str(100*(success/(success+fail))) + "%")
#Chance of imp dropping a diamond, approx: 18.1488%

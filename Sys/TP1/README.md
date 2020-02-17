## Compte Rendu TP1

### I. Commandes générales D'Unix

##### 1- Calendier 2009
```Unix
cal 2009
```

##### 2- Calendier de septembre 1752
```Unix
cal 9 1752
```

##### 3- La date au format jj-mm-aa
```Unix
date  +%d-%m-%Y
```

##### 4- Creation d'un fichier vide
```Unix
touch filename
```

##### 5- Nom d'hôte...
Nom d'hôte
```Unix
hostname
```
Relase et Version
```
lsb_release -a 
```

##### 6- Ulisateurs connectés
```Unix
who
```

##### 7- /etc/passwd format
```Unix
more /etc/passwd
```

##### 8- mkdir
```Unix
mkdir exercice
mkdir exercice/serie1
mkdir exercice/serie2
```

##### 9- Arborescence
```Unix
ls -Ra 
```

##### 10- Chemins
```Unix
ls -d $PWD/* 
```

##### 11- Copier un fichier
```Unix
cp /etc/passwd fic_pass
```

##### 12- Renommer un fichier
```Unix
mv fic_pass passwd
```


##### 13- Déplacer un fichier
```Unix
mv passwd exercice/serie1
```

##### 14- Copiers des fichiers
Nous sommes dans `/etc`
```Unix
cp passwd ~/exercice/serie2
cp group ~/exercice/serie2
```

Nous sommes dans `~/exercice/serie2`
```Unix
cp /etc/passwd .
cp /etc/group .
```
Nous sommes dans `~/exercice/serie1`
```Unix
cp /etc/passwd ../serie2
cp /etc/group ../serie2
```

##### 15- Changer le répertoire et lister les fichiers d'un autre
```Unix
cd exercice/serie1
ls -l ../serie2
```

##### 16- Créer un fichier et afficher ses caractéristiques
```
touch document
ls -l document
```

##### 17- Afficher les attribus des fichiers cachés
```
cd ~
ls -la
```

##### 18- Les attribus de '~'
```
ls -ld ~
```

##### 19- Comparer des fichiers
```
cmp filename1 filename2
```

##### 20- Copier une arborescence
```
mkdir exemple
cp -R exercice/ exemple/
```

##### 21- Supprimer une arborescence
```
rm -Rf exercice
```

### II. CREATION 
##### 1- PS
`ps` affiche:

`PID`: Un numéro unique à chaque processus

`TTY`: Le temps d'execution

`CMD`: le nom du processus 

##### Bonjour tout les 30 seconds
Le code source du processus
```c++
#include <stdio.h>
#include <unistd.h>
int	main() {	
	while (true) {
		printf("Bonjour!\n");
		sleep(30);	
	}
	return (0);
}
```
Après on compile par `gcc`
```c
gcc -O2 -Wall proc.c -o Proc
```
On lance `Proc` en arriere-plan
```
./Proc&
```
Pour obtenir le `PID` de `Proc` on utilise `ps`

Pour obtenir le numero du job de `Proc` on utilise `jobs`

##### 3- Tuer un script
```
kill 7548
```

##### 4- Script detaché
```
nohup ./Proc&
```
il ecrit ses sorties dans `nohup.out`

##### 5- PS
`ps` n'affiche pas `Proc` puisqu'il relié au terminal courant

##### 6- PS
```
ps -u brahim
```

##### 7- Tuer Proc et supprimer son fichier de sortie
```
kill 6584
rm -f nohup.out
```

##### 8. Temporary Files
```
sudo find /tmp -type f -mmin -1 -delete
```

### III. Communication des processus sous Linux
##### Exercice 1
```
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int	main() {
    int	pid[2] = {0, 0};

    printf("Current PID: %d\n", getpid());

    pid[0] = fork();
    if (pid[0] == 0) {
        printf("----------------------Proc1--------------\n");
        printf("Parent PID: %d \n", getppid());
        printf("Child PID: %d \n", getpid());
    }else{
        printf("----------------------Proc2--------------\n");
        printf("Parent PID: %d \n", pid[0]);
        printf("Child PID: %d \n", getpid());
    }
    return (0);
}
```

##### Exercice 2
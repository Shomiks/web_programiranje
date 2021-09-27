### Project specification and how it was used in the project

1. Shadow CLJS: biblioteka koja je potrebna kako bi se ClojureScript kod uspešno kompajlirao. Shadow CLJS se sastoji iz dva dela: 

  1.1 shadow-cljs biblioteka koja handle-uje ceo posao i 
  
  1.2 shadow-cljs npm paket koji nam obezbeđuje interfejs za pokretanje build funkcionalnosti direktno iz terminala. Konfiguracija koja je dobijena komandom npx create-cljs-  project korišćena je u izradi projekta. Npx je deo npm-a koji umesto nas instalira sve potrebne skripte. 

2. Reagent: biblioteka koja nam obezbeđuje prost način kreiranja React komponenti i njihovu upotrebu. Takođe omogućava nam momentalnu promenu na našoj aplikaciji nakon izmene koda, kao kod React-a. Komandom npx create-reagent-app generišemo sve potrebne fajlove za projekat kao npr. public folder. U aplikaciji su korišćene sledeće mogućnosti Reagenta: 

   2.1 pomoću funkcija napravljene su React komponente(npr. todo-input, todo-edit, todo-stats, todo-item...) koje se renderuju u DOM,
   
   2.2 koristi se Hiccup sintaksa kako bi se generisao HTML(u aplikaciji korišćeni vektori koji predstavljaju elemente i mape koje predstavljaju atribute): na primer  [:input.toggle {:type "checkbox" :checked done :on-change #(toggle id)}] i
   
   2.3 omogućava nam state management u komponenti pomoću Reagent atoma: na primer (let [val (r/atom title))

### Project functionality description

Projekat je u stvari jedna ček-lista koju sam nazvao Uradi me! Kao što sam napomenuo, u izradi su korišćeni Shadow CLJS i Reagent. Čitava aplikacija nalazi se u samo jednom fajl komponenti, core.cljs, koji se nalazi u folderu src/simpletodo. U folderu public/css nalazi se čitav stajling projekta u CSS formatu (bez korišćenja preprocessora).

Aplikacija ima sledeće funkcionalnosti:
1) Inicijalno imamo predefinisane obaveze koje trebamo da ispunimo, i njih možemo čekirati kao gotove ili ukloniti sa liste (ukoliko se jedna ukloni, u donjem levom uglu smanjiće se broj "items left", kao i u donjem desnom "clear completed")
2) Možemo dodati novu obavezu na spisak u tabu "What needs to be done?"
3) Možemo filtrirati obaveze po filterima ispod spiska: ALL, COMPLETED, ACTIVE
4) Ukoliko imamo čekiranu barem jednu obavezu, u donjem desno uglu pojaviće se dugme Clear completed koje će ukloniti sve obaveze koje su statusa COMPLETED
5) U gornjem levom uglu klikom na strelicu, možemo čekirati ili odčekirati SVE obaveze sa spiska

### Please follow [guides] in order to set up the project
[guides]: https://clojurescript.org/guides/quick-start

### Run project
```
npm install
npx shadow-cljs watch app
```
start a ClojureScript REPL
```
npx shadow-cljs browser-repl
```
### References

[ClojureScript: React with a Hiccup by David Vujic](https://www.youtube.com/watch?v=SVouy-Zd-_g&ab_channel=FuncProgSweden) - dosta sam naučio o samoj Hiccup/React sintaksi

[Func Prog Sweden - Youtube chanel](https://www.youtube.com/channel/UClIlgY1OC4wSVyqsEWOh9ZQ) - odličan kanal koji mi je pomagao kada god zapnem

[ClojureScript official documentation](https://clojurescript.org/reference/documentation) - dokumentacija na kakvu do sada nisam navikao, ali sam se snalazio i odatle učio

[Shadow-cljs](https://shadow-cljs.github.io/docs/UsersGuide.html) - shadow-cljs biblioteka za kompajliranje CLJS

[Reagent library](https://github.com/reagent-project/reagent) - Reagent biblioteka i dokumentacija koja mi je poslužila pri instalaciji

[Reagent guide](https://purelyfunctional.tv/guide/reagent) - primeri kodova Reagent biblioteke sa objašnjenjima

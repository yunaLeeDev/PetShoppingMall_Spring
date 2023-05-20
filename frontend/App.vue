<template>
  <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
    >
      <v-container class="py-0 fill-height">
        <v-avatar
          class="mr-10"
          color="grey darken-1"
          size="32"
        ></v-avatar>

        <v-btn
          href="/shop"
        >
         쇼핑몰
        </v-btn>

        <v-spacer></v-spacer>

        <v-responsive max-width="260">
          <v-text-field
            dense
            flat
            hide-details
            rounded
            solo-inverted
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item
                  v-for="item in items"
                  :key="item"
                  link
                  @click="addPet(item)"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ item }}
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  link
                  color="grey lighten-4"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      Refresh
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >


          <Pet @change="updatePet(pet)" :is="pets[index].type" v-model="pets[index]" v-for="(pet, index) in pets" :key="index"></Pet>

        

            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
//Pet을 import하여 사용한다.
import Pet from './components/Pet'
//Dog을 import하여 사용한다.
import Dog from './components/Dog'
//Cat을 import하여 사용한다.
import Cat from './components/Cat'
const axios = require('axios').default;

export default {
  name: 'App',
  components: {
    //import한 것들을 등록한다.
    Pet, Dog, Cat
  },
  data: () => ({
      
   items: [
     //강아지, 고양이라고 등록해 화면에 강아지를 등록하는 곳, 고양이를 등록하는 곳이 나타나도록 한다.
     '강아지',
     '고양이'
   ],
   pets:[
     
   ]
    }),

    created(){
      //created를 실행하면 init 메소드를 실행하도록 한다.
      this.init();
    },

    methods:{

      async init(){

      const response = await axios.get("/cats");
      this.pets = response.data._embedded.cats;
      },


      addPet(item){
        //item 중에서 강아지랑 일치하는 것이면 이 if문을 실행한다.
        if(item == "강아지"){
          this.pets.push( {
            //그 pet의 type은 dog
            type : 'Dog',
            //pet의 name은 멍멍이
            name : '멍멍이',
            //energy는 2
            energy : 2, 
            //appearance는 2
            appearance : 2
                      });
                    } 
                    
                    //아닌 경우 중에서 고양이인 경우는 if문을 돌린다.
                    else if(item == "고양이"){
                          this.pets.push( {
                          //pet의 type은 cat이다.
                          type : 'Cat',
                          //pet의 name은 냐옹이이다.
                          name : '냐옹이',
                          //pet의 energy는 2이다.
                          energy : 2, 
                          //pet의 appearace는 2이다.
                          appearance : 2
                  });
                    }

      axios.request({
        method: 'POST',
        url: 'cats',
        headers: {'Content-Type':'application/json'},
        data: this.pets[this.pets.length -1]
      });

      },

      updatePet(pet){
        //이 메소드로 가면 self링크로 가서 작업을 수행한다.
        axios.request({  
        method: 'PATCH',
        //pet에다가 self 링크를 걸어준다.
        url: new URL(pet._links.self.href).pathname,
        headers: {'Content-Type': 'application/json'},
        data: pet
      });
      },
        feedPet(pet){
        //이 메소드로 가면 feed 링크로 가서 작업을 수행한다.
        axios.request({
        method: 'PATCH',
        //pet에다가 feed 링크를 걸어준다.
        url: new URL(pet._links.feed.href).pathname,
        headers: {'Content-Type': 'application/json'},
        data: pet
      });
      },
        sleepPet(pet){
        //이 메소드로 가면 sleep 링크로 가서 작업을 수행한다.
        axios.request({
        method: 'PATCH',
        //pet에다가 sleep 링크를 걸어준다.
        url: new URL(pet._links.sleep.href).pathname,
        headers: {'Content-Type': 'application/json'},
        data: pet
      });
      },
        groomPet(pet){
        //이 메소드로 가면 groom 링크로 가서 작업을 수행한다.
        axios.request({
        method: 'PATCH',
        //pet에다가 groom 링크를 걸어준다.
        url: new URL(pet._links.groom.href).pathname,
        headers: {'Content-Type': 'application/json'},
        data: pet
      });
      }
    }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

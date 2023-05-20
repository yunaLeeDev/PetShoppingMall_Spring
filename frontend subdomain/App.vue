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
          v-for="link in links"
          :key="link.href"
          :href="link.href"
          text
        >
          {{ link.title }}
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
                <v-list-item @click="showCart=true">
                  <v-list-item-content>
                    <v-list-item-title>
                      카트보기
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
          <Cart v-if="showCart"></Cart>

          <Pet v-else v-model="pets[index]" v-for="(pet, index) in pets" :key="index"></Pet>

        

            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Pet from './components/Pet'
import Cart from './components/Cart'
const axios = require('axios').default;

export default {
  name: 'App',
  components: {
    Pet, Cart
  },
  data: () => ({
      links: [
        //애완동물 등록이라는 요소를 만들고 하이퍼링크를 걸어준다.
        {title:'애완동물 등록', href:"/"}
      ],
   items: [
     //item에는 강아지와 고양이를 등록해준다.
     '강아지',
     '고양이'
   ],
   pets:[
   ],
   //showcart에는 false를 기본형으로 유지한다.
   showCart: false
    }),
    created(){
      //init 메소드를 실행한다.
      this.init();
    },
    methods:{
      showCart(){
        //showcart메소드를 사용하면 showcart 필드를 true로 바꿔준다.
        this.showCart=true;
      },
      async init(){
      const response = await axios.get("/cats");
      this.pets = response.data._embedded.cats;
      },


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

<template>
 <v-data-table
    :headers="headers"
    :items="cartItems"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>
</template>

<script>
const axios = require('axios').default;

export default {
  name: 'Cart',
  components: {
  },
  data: () => ({
     headers: [
       //카트에 담긴 pet의 속성을 어떻게 나타낼 것인지 나열해준다.
        { text: '이름', value: 'petDetail.name' },
        { text: '활동성', value: 'petDetail.energy' },
        { text: '외모', value: 'petDetail.appearance' },
        { text: '결제방법', value: 'payment.method' },
        { text: '결제상태', value: 'payment.status' }

     ],
    cartItems: [],


   showCart: false
    }),

    created(){
      //init메소드를 실행한다.
      this.init();
    },

    methods:{


      showCart(){
        this.showCart=true;
      },

      async init(){

      const response = await axios.get("/cartItems");
      this.cartItems = response.data._embedded.cartItems;
      this.cartItems.forEach(async cartItem => {
        const response = await axios.get(new URL(cartItem._links.pet.href).pathname);
        cartItem.petDetail = response.data;
      })
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

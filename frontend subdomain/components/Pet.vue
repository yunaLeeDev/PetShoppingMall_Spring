<template>
     <v-card
    class="mx-auto"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          {{value.type}}
        </div>
    
        <v-list-item-title class="text-h5 mb-1">
          {{value.name}}
        </v-list-item-title>
        <v-list-item-subtitle >에너지는 {{value.energy}}이고 외모지수는 {{value.appearance}}입니다.</v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
        color="grey"
      ></v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
     <v-chip v-if="inTheCart"> 카트에 담겼습니다 </v-chip>
      <v-btn
        v-else
        outlined
        rounded
        text

        @click="addToCart"
      >
      카트 담기
      </v-btn>
  <slot name="buttons"></slot>
    
    </v-card-actions>

  </v-card>

</template>

<script>

  const axios = require('axios').default;
  export default {
    name: 'Pet',

    props: { 
      value : Object,
      editmode : Boolean
    },

    data: () => {
      return{
        inTheCart: false
      }
    },

    methods:{
      async addToCart(){
        //카트에 담는 메소드이다.
        var cartItem = {
          //pet의 self링크를 걸어준다.
          pet: this.value._links.self.href,
          //customer을 지정해준다.
          customer: "http://localhost:8088/customers/help@uengine.org",
          payment: {
            //payment의 method와 status를 등록해준다.
            method: "신용카드",
            status: "결제완료"
          }
        }

        await axios.request({
          //post메소드를 사용하면
        method: 'POST',
        //cartItems로 링크를 걸어주고 이 작업을 수행한다.
        url: "/cartItems",
        headers: {'Content-Type': 'application/json'},
        data: cartItem
      });

        this.inTheCart=true;
      },
     
        
      


    }
  }
</script>

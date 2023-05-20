<template>


<div>

 <Pet v-model="value">
  <template v-slot:buttons>
    <v-btn 
     outlined
        rounded
        text    
    @click="groom">GROOM</v-btn>
  </template>
 </Pet>
 
</div>

</template>

<script>

  const axios = require('axios').default;
import Pet from './Pet'

  export default {
    name: 'CAT',
 components :{
      Pet
    },
    //Pet의 자식객체로 등록함
    mixins:[Pet],
     
    methods:{
      //groom하는 메소드이다.
     async groom(){
        
      // groom 링크로 이동하여 작업을 수행하는 메소드이다.
        await axios.request({
          
        // put 메소드를 사용하고, application으로 가서 request를 수행한다.
        method: 'PUT',
        
        // groom 링크로 이동한다.
        url: new URL(this.value._links.groom.href).pathname,
        headers: {'Content-Type': 'application/json'},
      });
      //부모 객체의 refresh 메소드를 사용한다.
      this.refresh();


       }
    }
  }
</script>

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
        <v-list-item-title class="text-h5 mb-1" v-if="editmode">
         <v-text-field v-model= "value.name"></v-text-field>
        </v-list-item-title>
        <v-list-item-title class="text-h5 mb-1" @click="toggleEditMode" v-else>
          {{value.name}}
        </v-list-item-title>
        <v-list-item-subtitle @click="toggleEditMode">에너지는 {{value.energy}}이고 외모지수는 {{value.appearance}}입니다.</v-list-item-subtitle>
      </v-list-item-content>

      <v-list-item-avatar
        tile
        size="80"
        color="grey"
      ></v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text

        @click="eats"
      >
      먹이주기
      </v-btn>
      <v-btn
        outlined
        rounded
        text

        @click="sleep"
      >
      잠자기
      </v-btn>
  <slot name="buttons"></slot>
    
    </v-card-actions>

  </v-card>

</template>

<script>

  const axios = require('axios').default;
  export default {
    name: 'Pet',
  //class 명은 pet이다.
    props: { 
      value : Object,
      editmode : Boolean
    },


    methods:{
      //eat 메소드이다.
      async eats(){
        // feed링크로 이동하여 작업을 수행하는 메소드이다.
        await axios.request({
        // put 메소드를 사용하고, application으로 가서 request를 수행한다.
        method: 'PUT',
        // feed 링크로 이동한다.
        url: new URL(this.value._links.feed.href).pathname,
        headers: {'Content-Type': 'application/json'},
      });
      //refresh해서 즉각 업데이트 해준다.
      this.refresh();
    
      },
      //sleep 메소드이다.
      async sleep(){
      // sleep 링크로 이동하여 작업을 수행하는 메소드이다.
        await axios.request({
        // put 메소드를 사용하고, application으로 가서 request를 수행한다.
        method: 'PUT',
        // sleep 링크로 이동한다.
        url: new URL(this.value._links.sleep.href).pathname,
        headers: {'Content-Type': 'application/json'},
      });
      //refresh해서 즉각 업데이트 해준다.
      this.refresh();
        
        },
        //refresh를 해주는 메소드이다.
        async refresh(){
        var response = await axios.get(new URL(this.value._links.self.href).pathname);

      if(response){
        this.value = response.data;
        //change해서 input이 사용되면 이를 유지시킨다.
        this.$emit("input", this.value);
      }
        },
        //편집하는 메소드이다.
        toggleEditMode(){
          this.editmode = !this.editmode;

        //change해서 change이 사용되면 이를 유지시킨다.
        this.$emit("change", this.value);
        },

    }
  }
</script>

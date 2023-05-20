<template>
  <Pet v-model="value"></Pet>
</template>

<script>
  //pet을 import하여 사용한다.
  import Pet from './Pet'
  export default {

    name: 'Dog',
    components :{
      //component로 pet을 등록하여 사용한다.
      Pet
    },
  //pet의 자식객체로 등록한다.
    mixins :[Pet],
    methods:{
    }
  }
</script>

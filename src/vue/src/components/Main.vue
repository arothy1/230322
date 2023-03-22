<template>
  <v-container>
    <v-row>
      <v-col align="start">
        <h3>인기 검색어</h3>
        <v-chip v-for="(item, index) in keywords" v-bind:key="index">
          {{ item.keyword }}({{ item.count }})
        </v-chip>
      </v-col>
    </v-row>
    <Blog @get-keywords="getKeywords"/>
  </v-container>
</template>

<script>
import Blog from './view/blog/Blog'
export default {
  components: {Blog},
  data () {
    return {
      keywords: []
    }
  },
  created () {
    this.getKeywords()
  },
  methods: {
    getKeywords () {
      this.$http.get('/api/blog/keyword/counter')
        .then(res => {
          console.log(res)
          this.keywords = res.data.data
        })
        .catch(err => {
          alert(err)
        })
    }
  }
}
</script>

<style scoped>
</style>

<template>
  <v-container>
    <v-row>
      <v-col cols="8" offset="2">
        <v-text-field
          v-model="query"
          placeholder="검색어를 입력하세요.[ENTER]"
          @keydown.enter="getBlogs"
        >
          <template v-slot:append-outer>
            <v-btn-toggle v-model="sort">
              <v-btn small :value="'ACCURACY'">정확도순</v-btn>
              <v-btn small :value="'RECENCY'">최신순</v-btn>
            </v-btn-toggle>
          </template>
        </v-text-field>
      </v-col>
    </v-row>
    <v-row>
      <v-col v-for="(item, index) in blogs" v-bind:key="index" cols="3">
        <v-card :href="item.url">
          <v-img :src="item.thumbnail"
          ></v-img>
          <v-card-title v-html="item.title"/>
          <v-card-text v-html="item.contents"/>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data () {
    return {
      blogs: [],
      pagination: {
        page: 1,
        itemsPerPage: 12,
        totalCount: 0
      },
      sort: 'ACCURACY',
      query: null
    }
  },
  created () {
    this.getBlogs()
  },
  methods: {
    getBlogs () {
      this.blogs = this.$http.get(`/api/blog/documents?query=${this.query}&page=${this.pagination.page}&itemsPerPage=${this.pagination.itemsPerPage}&sort=${this.sort}`)
        .then(res => {
          console.log(res.data)
          this.blogs = res.data.blogDocuments
          this.pagination = res.data.pagination
        })
        .catch(e => {
          alert(e)
        })
        .finally(() => {
          this.$emit('get-keywords')
        })
    }
  }
}
</script>

<style scoped>
</style>

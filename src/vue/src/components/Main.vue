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
    <v-btn @click="prev">prev</v-btn>
    <v-btn @click="next">next</v-btn>
    <v-row>
      <v-col cols="8" offset="2">
        <v-text-field
          v-model="query"
          placeholder="검색어를 입력하세요.[ENTER]"
          @keyup.enter="getBlogs(true)"
          :loading="loading"
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
      keywords: [],
      pagination: {
        page: 1,
        itemsPerPage: 12,
        length: 0
      },
      loading: false,
      blogs: [],
      sort: 'ACCURACY',
      query: null
    }
  },
  created () {
    this.getKeywords()
  },
  methods: {
    getKeywords () {
      this.$http.get('/api/blog/keyword/counter')
        .then(res => {
          this.keywords = res.data.data
        })
        .catch(err => {
          alert(err)
        })
    },
    getBlogs (increaseCount) {
      if (this.loading) {
        return
      }
      this.loading = true
      this.blogs = this.$http.get(`/api/blog/documents?query=${this.query}&page=${this.pagination.page}&itemsPerPage=${this.pagination.itemsPerPage}&sort=${this.sort}&increaseSearchCount=${increaseCount}`)
      .then(res => {
        this.blogs = res.data.blogDocuments
        this.pagination = res.data.pagination
      })
      .catch(e => {
        alert(e)
      })
      .finally(() => {
        this.loading = false
        this.getKeywords()
      })
    },
    prev () {
      if (!this.blogs.length || this.pagination.page == 1) {
        return
      }
      this.pagination.page = this.pagination.page - 1
      this.getBlogs(false)
    },
    next () {
      if (!this.blogs.length || this.pagination.totalCount / this.pagination.itemsPerPage == this.pagination.page) {
        return
      }
      this.pagination.page = this.pagination.page + 1
      this.getBlogs(false)
    }
  }
}
</script>

<style scoped>
</style>

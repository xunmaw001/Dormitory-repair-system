<template>
    <view class="container my-publish-pv">
        <form>
            <view class="cu-form-group margin-top">
                <input
                        :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 0)","borderColor":"#008761","borderRadius":"0px","color":"rgba(14, 183, 34, 1)","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx"}'
                        v-model="forum.forumName" placeholder="标题"></input>
            </view>








            <view class="cu-form-group margin-top">
                <picker @change="setIsDoneTap" :value="index"  :range="forumTypesOptions" range-key="indexName">
                    <view class="uni-picker-type"
                          :style='{"lineHeight":"80rpx","fontSize":"28rpx","color":"#008761","textAlign":"center"}'>
                        {{forum.forumTypes?forum.forumValue:"请选择帖子类型"}}</view>
                </picker>
            </view>




            <view class="cu-form-group margin-top">
				<textarea
                        :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 0)","borderColor":"rgba(227, 227, 227, 1)","borderRadius":"8rpx","color":"#333","borderWidth":"6rpx","fontSize":"28rpx","borderStyle":"solid","height":"300rpx"}'
                        style="height: 500upx;" v-model="forum.forumContent" placeholder="内容"></textarea>
            </view>
            <view class="cu-form-group margin-top" style="text-align:center">
                <button
                        :style='{"boxShadow":"0 0 0px rgba(0,0,0,0) inset","backgroundColor":"#008761","borderColor":"rgba(255, 255, 255, 1)","borderRadius":"8rpx","color":"#fff","borderWidth":"1","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'
                        @tap="onSubmitTap" class="bg-red margin-tb-sm">确认提交</button>
            </view>
        </form>
    </view>
</template>

<script>
    export default {
        data() {
            return {
                forum: {
                    forumContent: '',
                    id: '',
                    forumName: '',
                    forumTypes: null,
                    forumStateTypes:1,
                },
                index: 0,
                forumTypesOptions: [],
                username: '',
                user: {}
            }
        },
        async onLoad(options) {
            let _this = this
            let table = uni.getStorageSync("nowTable");
            // 获取用户信息
            let res = await _this.$api.session(table);
            _this.user = res.data;
            if (table == `xuesheng`) {
                _this.xueshengId = _this.user.id
            }
            if (options.id) {
                _this.id = options.id;
                let res = await _this.$api.info('forum', _this.id);
                _this.forum = res.data
            }
            let param = {
                page: 1,
                limit: 9999,
                dicCode:'forum_types'
            }
            let dictionaryLsit = await _this.$api.page('dictionary', param);
            _this.forumTypesOptions = dictionaryLsit.data.list
            _this.styleChange()
        },
        methods: {
            styleChange() {
                this.$nextTick(() => {
                    // document.querySelectorAll('.my-publish-pv .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
                    //   el.style.backgroundColor = this.myPublishForm.content.yaoxianStyle.backgroundColor
                    // })
                })
            },
            async onSubmitTap() {
                this.forum.username = this.username;
                if (this.id) {
                    await this.$api.update('forum', this.forum);
                } else {
                    await this.$api.save('forum', this.forum);
                }
                this.$utils.msgBack('操作成功');
            },
            setIsDoneTap(e) {
                this.index = e.target.value
                this.forum.forumTypes = this.forumTypesOptions[this.index].codeIndex
                this.forum.forumValue = this.forumTypesOptions[this.index].indexName
            },
        }
    }
</script>

<style>
    page {
        background-color: #fff;
    }

    .container {
        padding: 20upx 24upx;
    }

    .container:after {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        content: '';
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
    }

    .cu-form-group {
        padding: 0;
        background-color: transparent;
        min-height: inherit;
    }

    .cu-form-group+.cu-form-group {
        border: 0;
    }

    .cu-form-group uni-input {
        padding: 0 30upx;
    }

    .cu-form-group uni-textarea {
        padding: 30upx;
        margin: 0;
    }

    .cu-form-group uni-picker::after {
        line-height: 80rpx;
    }

    .bg-red {
        line-height: 80rpx;
    }
</style>

import services.LgtmService
import util.GithubAuthUtil

def githubAuthUtil = new GithubAuthUtil(request, response)
githubAuthUtil.withValidUser('/upload') {
    def ul = LgtmService.instance.getUserList(githubAuthUtil.username).blockingGet()
    request.setAttribute 'banned', ul.bannedFromUpload
    forward '/WEB-INF/pages/upload.gtpl'
}

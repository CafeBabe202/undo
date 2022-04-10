package top.cafebabe.undo.article.controller;

import org.springframework.web.bind.annotation.*;
import top.cafebabe.undo.article.bean.Article;
import top.cafebabe.undo.article.form.EditArticleForm;
import top.cafebabe.undo.article.service.ArticleService;
import top.cafebabe.undo.article.service.ClazzService;
import top.cafebabe.undo.article.util.Checker;
import top.cafebabe.undo.article.util.ClassConverter;
import top.cafebabe.undo.article.util.SessionUtil;
import top.cafebabe.undo.common.bean.LoginUser;
import top.cafebabe.undo.common.bean.ResponseMessage;
import top.cafebabe.undo.common.util.MessageUtil;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author cafababe
 */
@RestController()
@RequestMapping("/article")
public class ArticleCtl {

    final ArticleService articleService;
    final ClazzService clazzService;

    public ArticleCtl(ArticleService articleService, ClazzService clazzService) {
        this.articleService = articleService;
        this.clazzService = clazzService;
    }

    @PostMapping("/editArticle.token")
    public ResponseMessage addArticle(@RequestBody EditArticleForm form, HttpSession session) {
        LoginUser loginUser = SessionUtil.getLoginUser(session);
        if (loginUser == null)
            return MessageUtil.error("变量错误");

        if (!Checker.check(form))
            return MessageUtil.fail("数据异常");

        Article article = ClassConverter.toArticle(form);
        article.setUserId(loginUser.getId());

        if ("-1".equals(form.getId()))
            return articleService.addArticle(article, form.getContent()) ?
                    MessageUtil.ok("添加成功") : MessageUtil.error("添加失败");
        else
            return MessageUtil.error("功能未实现");

    }

    @PostMapping("/deleteArticle.token/{articleId}")
    public ResponseMessage deleteArticle(@PathVariable String articleId, HttpSession session) {
        LoginUser loginUser = SessionUtil.getLoginUser(session);
        if (loginUser == null)
            return MessageUtil.error("变量错误");

        try {
            return articleService.deleteArticle(loginUser.getId(), Integer.parseInt(articleId)) ?
                    MessageUtil.ok("删除成功") : MessageUtil.fail("删除失败");
        } catch (Exception e) {
            return MessageUtil.fail("数据异常");
        }
    }

    @PostMapping("/changePrivate.token/{clazzId}")
    public ResponseMessage changePrivate(@PathVariable String clazzId, HttpSession session) {
        LoginUser loginUser = SessionUtil.getLoginUser(session);
        if (loginUser == null)
            return MessageUtil.error("变量错误");
        try {
            return articleService.changePrivate(loginUser.getId(), Integer.parseInt(clazzId)) ?
                    MessageUtil.ok("设置成功") : MessageUtil.error("设置失败");
        } catch (NumberFormatException e) {
            return MessageUtil.fail("设置失败");
        }
    }

//    @PostMapping("editArticle.token")


    @GetMapping("/getStatistics.token")
    public ResponseMessage getStatistics(@RequestParam(value = "id", defaultValue = "-1") String clazzId, HttpSession session) {
        LoginUser loginUser = SessionUtil.getLoginUser(session);
        if (loginUser == null)
            return MessageUtil.error("变量错误");

        try {
            Map<String, Integer> statistics = articleService.getStatistics(loginUser.getId(), Integer.parseInt(clazzId));
            statistics.put("clazzNum", clazzService.getAllClazz(loginUser.getId()).size());
            return MessageUtil.ok(statistics);
        } catch (Exception e) {
            return MessageUtil.fail("变量错误");
        }

    }

    @GetMapping("/getArticles.token/{clazzId}")
    public ResponseMessage getArticles(@PathVariable String clazzId, HttpSession session) {
        LoginUser loginUser = SessionUtil.getLoginUser(session);
        if (loginUser == null)
            return MessageUtil.error("变量错误");

        try {
            return MessageUtil.ok(articleService.getArticlesByClazz(loginUser.getId(), Integer.parseInt(clazzId)));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.ok("变量错误");
        }
    }

}

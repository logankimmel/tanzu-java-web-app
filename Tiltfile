SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='your-registry.io/project/tanzu-java-web-app-source')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='default')

k8s_custom_deploy(
    'tanzu-java-web-app-dev',
    apply_cmd="tanzu apps workload apply tanzu-java-web-app-dev --live-update" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --namespace " + NAMESPACE +
               " --type web" +
               " --yes >/dev/null" +
               " && kubectl get workload tanzu-java-web-app-dev --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete tanzu-java-web-app-dev --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('tanzu-java-web-app-dev', port_forwards=["8081:8080"],
            extra_pod_selectors=[{'serving.knative.dev/service': 'tanzu-java-web-app-dev'}])
allow_k8s_contexts('lkimmel')
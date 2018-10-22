### Minikube installed on Windows 10 Pro doesn't run when Hyper-V and VirtualBox are both installed

Minikube doesn't run when both of them are installed, run this command to skip the pre-create check.

```
docker-machine create -d virtualbox --virtualbox-no-vtx-check test
```

### Minikube doesn't run when doing `minikube start`

1. Make sure you have external Virtual Switch setup
2. Make sure your internet is connected properly. If you're using Switch A you should be connected to it (computer network)
3. Run with this command `minikube start --vm-driver hyperv --hyperv-virtual-switch "Primary Virtual Switch" --bootstrapper localkube`

\*note: localkube bootstrapper was deprecated at the time of writing. Consider using kubeadm

### `minikube dashboard` is not working

For some reason minikube dashboard addon is not started/added when `minikube start` is ran. The alternative is to manually add/activate the plugin by running:

 ```
 kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/master/src/deploy/recommended/kubernetes-dashboard.yaml
 ```

It can then be accessed using `minikube dashboard`
